package sq_ch11_payments.sq_ch11_payments.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import sq_ch11_payments.sq_ch11_payments.model.Payment;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentsController {

    //using a logger to prove the right controller's method
    //gets the correct data when the endpoint is called.
    private static Logger logger =
            Logger.getLogger(PaymentsController.class.getName());

    @PostMapping("/payment")
    public ResponseEntity<Payment> createPayment(
            @RequestHeader String requestId,
            @RequestBody Payment payment
    ) {
        logger.info("Received request with ID " + requestId +
                " ; Payment Amount: " + payment.getAmount());

        //The method sets a random value for the payment's ID
        payment.setId(UUID.randomUUID().toString());

        //The controller actions returns the HTTP response.
        //The response has a header and the response body that contains
        //the payment with the random ID value set.
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("requestId", requestId)
                .body(payment);
    }
}
