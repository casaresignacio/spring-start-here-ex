package sq_ch10_ex5.sq_ch10_ex5.service;

import org.springframework.stereotype.Service;
import sq_ch10_ex5.sq_ch10_ex5.DTO.PaymentDetails;

@Service
public class PaymentService {

    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
