package ma.enset.aspects;

import ma.enset.services.SecurityContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class AuthorisationAspect {
    @Around(value = "@annotation(securedByAspect)", argNames = "proceedingJointPoint,securedByAspect")
    public Object secure(ProceedingJoinPoint proceedingJointPoint, SecuredByAspect securedByAspect) throws Throwable {
        String[] roles = securedByAspect.roles();
        boolean authorized = false;
        System.out.println("From AuthorisationAspect: Authorisation before process() ...");
        for (String role : roles) {
            if (SecurityContext.hasRole(role)) {
                authorized = true;
                break;
            }

        }
        if (authorized) {
            Object result = proceedingJointPoint.proceed();
            return result;
        }
        throw new RuntimeException("Not authorized");
    }
}
