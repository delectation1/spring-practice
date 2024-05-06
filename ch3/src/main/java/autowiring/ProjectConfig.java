package autowiring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wiring.Parrot;
import wiring.Person;

@Configuration
public class ProjectConfig {
    @Bean
    public wiring.Parrot parrot() {
        wiring.Parrot parrot = new Parrot();
        parrot.setName("Test");
        return parrot;
    }

    @Bean
    public wiring.Person person() {
        wiring.Person person = new Person();
        person.setName("Human");
        person.setParrot(parrot());
        return person;
    }
}