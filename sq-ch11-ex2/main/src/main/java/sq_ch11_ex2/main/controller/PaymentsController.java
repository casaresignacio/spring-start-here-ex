package sq_ch11_ex2.main.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sq_ch11_ex2.main.PaymentsProxy;
import sq_ch11_ex2.main.model.Payment;

@RestController
public class PaymentsController {

    private final PaymentsProxy paymentsProxy;

    public PaymentsController(PaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }

    //Define a controller action and map it io the /payment path
    @PostMapping("/payment")
    public Payment createPayment(
            @RequestBody Payment payment
    ){
        //Call the proxy method, which in turn calls the endpoint of the payments service.
        //We get the response body and return the body to the client.
        return paymentsProxy.createPayment(payment);
    }
}
