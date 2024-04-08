package banking.model;

import java.util.Optional;

public record BankingDTO(String status, Optional<Long> currentBalance, Optional<String> errorMessage) {
}
