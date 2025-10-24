package sq_ch13_ex1.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sq_ch13_ex1.main.dto.TransferRequest;
import sq_ch13_ex1.main.model.Account;
import sq_ch13_ex1.main.service.TransferService;

import java.util.List;

@RestController
public class AccountController {

    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }


    //We use HTTP POST method for the /transfer endpoint because
    //it operates changes in the database's data.
    @PostMapping("/transfer")
    public void transferMoney(
            @RequestBody TransferRequest request //get the values needed using request body
            ) {
        //calling the transferMoney service that implements the transfer money use case
        transferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount()
        );
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return  transferService.getAllAccounts();
    }
}
