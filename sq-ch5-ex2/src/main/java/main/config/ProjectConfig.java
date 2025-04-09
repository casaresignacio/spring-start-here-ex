package main.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"main.services","main.repositories"})
public class ProjectConfig {
}
