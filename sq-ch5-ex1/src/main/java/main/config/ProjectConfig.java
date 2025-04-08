package main.config;

import main.services.CommentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    //Adds the CommentService bean to the Spring context
    @Bean
    public CommentService commentService() {
        return new CommentService();
    }
}
