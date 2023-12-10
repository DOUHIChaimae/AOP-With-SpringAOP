package ma.enset.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class LogAspect {
    @Before("execution(public void process())")
    public void log() {
        System.out.println("From LogAspect: Log before process() ...");
    }
}
