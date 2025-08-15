package sq_ch11_ex3.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import sq_ch11_ex3.main.model.Payments;

@Component
public class PaymentsProxy {

    private final WebClient webClient;

    //Taking the base URL from the properties file.
    @Value("${name.service.url}")
    private String url;

    public PaymentsProxy(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Payments> createPayments(
           String requestId,
           Payments payments) {
        return webClient.post()
                .uri(url + "/payment")
                .header("requestId", requestId)
                .body(Mono.just(payments), Payments.class)
                .retrieve()
                .bodyToMono(Payments.class);
    }
}
