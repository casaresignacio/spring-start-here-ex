package sq_ch11_ex2.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sq_ch11_ex2.main.model.Payment;

import java.util.UUID;

@Component
public class PaymentsProxy {

    private final RestTemplate rest;

    //We take the URL to the payment service from the properties file.
    @Value("${name.service.url}")
    private String paymentsServiceUrl;

    //we inject the RestTemplate from the Srping context using constructor DI.
    public PaymentsProxy(RestTemplate rest) {
        this.rest = rest;
    }

    public Payment createPayment (Payment payment) {
        String uri = paymentsServiceUrl + "/payment";

        //Build the HttpHeaders object to define the HTTP request headers.
        HttpHeaders headers = new HttpHeaders();
        headers.add("requestId",
                UUID.randomUUID().toString());

        //Build the HttpEntity object to define the request data
        HttpEntity<Payment> httpEntity =
                new HttpEntity<>(payment, headers);

        //Send the HTTP request and retrieve the data on the HTTP response
        ResponseEntity<Payment> response =
                rest.exchange(uri,
                        HttpMethod.POST,
                        httpEntity,
                        Payment.class);

        //Return the HTTP response body
        return response.getBody();
    }


}
