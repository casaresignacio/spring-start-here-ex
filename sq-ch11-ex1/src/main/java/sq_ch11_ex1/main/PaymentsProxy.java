package sq_ch11_ex1.main;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import sq_ch11_ex1.main.model.Payment;

//We use the @FeignClient annotation to configure  the REST client.
//A minimal configuration defines a name and the endpoint base URL.
@FeignClient(name = "payments",
             url = "${name.service.url}")
public interface PaymentsProxy {

    //We specify the endpoint's path and HTTP method
    @PostMapping("/payment")
    Payment createPayment(
            //We define the request headers and body
            @RequestHeader String requestId,
            @RequestBody Payment payment);
}
