package sq_ch10_ex6.sq_ch10_ex6.service;

import org.springframework.stereotype.Service;
import sq_ch10_ex6.sq_ch10_ex6.DTO.PaymentDetails;

@Service
public class PaymentService {

    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
