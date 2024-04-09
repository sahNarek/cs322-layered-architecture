package banking;

import banking.model.BankingDTO;
import banking.model.BankingRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/account")
public class BankingControllerImpl implements BankingController {
    private final BankingService BankingService;

    public BankingControllerImpl(BankingService BankingService) {
        this.BankingService = BankingService;
    }

    @Override
    @PostMapping("/debit")
    public BankingDTO debit(@RequestBody BankingRequest request) {
        return BankingService.debit(request.userId(), request.accountId(), request.amount());
    }

    @Override
    @PostMapping("/credit")
    public BankingDTO credit(@RequestBody BankingRequest request) {
        return BankingService.credit(request.userId(), request.accountId(), request.amount());
    }
}
