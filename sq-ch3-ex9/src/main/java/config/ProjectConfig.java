package config;

import beans.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "beans")
public class ProjectConfig {

    @Bean
    public Parrot  parrot1 () {
        Parrot p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean
    // the bean named parrot2 is the one that Spring injects into the Person bean.
    public Parrot parrot2 () {
        Parrot p = new Parrot();
        p.setName("Miki");
        return p;
    }


}
