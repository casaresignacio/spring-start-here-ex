package main.config;

import main.aspects.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//using componentScan to tell Spring where to search for classes annotated with stereotype anotations
@ComponentScan(
        basePackages = {"main.services"}
)
//Enables the aspects mechanism in our Spring app
@EnableAspectJAutoProxy
public class ProjectConfig {

    //Adds an instance of the LoggingAspect class to the Spring context
    @Bean
    public LoggingAspect aspect(){
        return new LoggingAspect();
    }

}
