package sq_ch11_ex1.main.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
//We enable the OpenFeign clients and tell the OpenFeign dependency
//where to search for the proxy contracts.
@EnableFeignClients(
        basePackages = "sq_ch11_ex1.main"
)
public class ProjectConfig {
}
