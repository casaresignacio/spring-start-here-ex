package sq_ch11_ex3.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ProjectConfig {

    //Creating a WebClient bean and adds it in the Spring context

    @Bean
    public WebClient webClient() {
        return WebClient
                .builder()
                .build();
    }
}
