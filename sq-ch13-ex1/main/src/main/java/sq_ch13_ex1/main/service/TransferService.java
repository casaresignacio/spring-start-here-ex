package sq_ch13_ex1.main.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sq_ch13_ex1.main.model.Account;
import sq_ch13_ex1.main.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {
    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    //We use the @Transactional annotation to instruct Spring to wrap the method's calls in transactions.
    @Transactional
    public void transferMoney(long idSender,
                              long idReceiver,
                              BigDecimal amount) {

        //We get the accounts' details to find the current amount in eac account.
        Account sender = accountRepository.findAccountById(idSender);
        Account receiver = accountRepository.findAccountById(idReceiver);

        //We calculate the new amount for sender and receiver
        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        //We set the new amount value for the sender and destination account.
        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAllAccount();
    }
}
