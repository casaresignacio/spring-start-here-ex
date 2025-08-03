package sq_ch10_ex5.sq_ch10_ex5.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sq_ch10_ex5.sq_ch10_ex5.DTO.PaymentDetails;
import sq_ch10_ex5.sq_ch10_ex5.service.ErrorDetails;
import sq_ch10_ex5.sq_ch10_ex5.service.NotEnoughMoneyException;
import sq_ch10_ex5.sq_ch10_ex5.service.PaymentService;

@RestController
public class PaymentController {


    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment() {
        try{
            PaymentDetails paymentDetails =
                    paymentService.processPayment();
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(paymentDetails);
        } catch (NotEnoughMoneyException e){
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("Not enough money to make the payment.");
            return ResponseEntity
                    .badRequest()
                    .body(errorDetails);
        }
    }
}
