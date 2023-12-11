package ma.enset;

import ma.enset.services.IMetier;
import ma.enset.services.SecurityContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = {"ma.enset.services", "ma.enset.aspects"})
public class Application {
    public static void main(String[] args) {
        SecurityContext.authenticate("root", "1234", new String[]{"USER"});
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(Application.class);

        IMetier metier = applicationContext.getBean(IMetier.class);
        System.out.println(metier.getClass().getName());
        metier.process();
        System.out.println("data = " + metier.compute());
    }
}