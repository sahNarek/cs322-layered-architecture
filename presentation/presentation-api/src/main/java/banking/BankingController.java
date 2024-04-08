package banking;

import banking.model.BankingDTO;
import banking.model.BankingRequest;

public interface BankingController {
    public BankingDTO debit(BankingRequest request);
    public BankingDTO credit(BankingRequest request);
}
