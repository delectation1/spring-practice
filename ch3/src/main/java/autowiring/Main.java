package autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import wiring.Parrot;
import wiring.Person;
import wiring.ProjectConfig;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new
                AnnotationConfigApplicationContext(ProjectConfig.class);

        wiring.Person person = context.getBean(Person.class);
        wiring.Parrot parrot = context.getBean(Parrot.class);

        System.out.println(parrot.toString());
        System.out.println(person.toString());
    }
}