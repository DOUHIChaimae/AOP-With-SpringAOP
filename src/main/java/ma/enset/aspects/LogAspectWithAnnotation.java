package ma.enset.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
@EnableAspectJAutoProxy
public class LogAspectWithAnnotation {
    Logger logger = Logger.getLogger(LogAspectWithAnnotation.class.getName());
    @Around("@annotation(ma.enset.aspects.Log)")

    public Object log(ProceedingJoinPoint proceedingJointPoint) throws Throwable {
        long t1 = System.currentTimeMillis();
        logger.info("From LogAspect: Log before process() ..." + proceedingJointPoint.getSignature());
        Object result = proceedingJointPoint.proceed();
        logger.info("From LogAspect: Log before process() ..." + proceedingJointPoint.getSignature());
        long t2 = System.currentTimeMillis();
        logger.info("From LogAspect: Log after process() ..." + proceedingJointPoint.getSignature());
        logger.info("Duration:" + (t2 - t1));
        return result;
    }


}
