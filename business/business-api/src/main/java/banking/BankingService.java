package banking;
import banking.model.BankingDTO;

public interface BankingService {
    public BankingDTO debit(Long userID, Long accountId, Long amount);
    public BankingDTO credit(Long userID, Long accountId, Long amount);
}
