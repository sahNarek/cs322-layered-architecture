package banking;

import banking.model.Account;
import banking.model.BankingDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankingServiceImpl implements BankingService {
    private final AccountRepository accountRepository;

    public BankingServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    //    @Override
    public BankingDTO debit(Long userID, Long accountId, Long amount) {
        Optional<Account> searchResult = accountRepository.findById(accountId);
        if (searchResult.isEmpty()) {
            return new BankingDTO("Failure", Optional.empty(), Optional.of("Account Not Found!"));
        }
        Account account = searchResult.get();
        if (!account.debit(amount)) {
            return new BankingDTO("Failure", Optional.of(account.getCurrentBalance()), Optional.of("The requested amount exceeds the debit limit!"));
        }
        accountRepository.save(account);
        return new BankingDTO("Successful", Optional.of(account.getCurrentBalance()), Optional.empty());
    }

    //    @Override
    public BankingDTO credit(Long userID, Long accountId, Long amount) {
        Optional<Account> searchResult = accountRepository.findById(accountId);
        if (searchResult.isEmpty()) {
            return new BankingDTO("Failure", Optional.empty(), Optional.of("Account Not Found!"));
        }
        Account account = searchResult.get();
        if (!account.credit(amount)) {
            if (amount > account.getCurrentBalance()) {
                return new BankingDTO("Failure", Optional.of(account.getCurrentBalance()), Optional.of("Not enough balance on the account!"));
            }
            return new BankingDTO("Failure", Optional.of(account.getCurrentBalance()), Optional.of("The requested amount exceeds the credit limit!"));
        }
        accountRepository.save(account);
        return new BankingDTO("Successful", Optional.of(account.getCurrentBalance()), Optional.empty());
    }

}
