package sq_ch10_ex7.sq_ch10_ex7.service;

import org.springframework.stereotype.Service;
import sq_ch10_ex7.sq_ch10_ex7.DTO.PaymentDetails;

@Service
public class PaymentService {

    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
