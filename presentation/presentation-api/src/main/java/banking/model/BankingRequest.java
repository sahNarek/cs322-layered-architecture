package banking.model;
import jakarta.annotation.Nonnull;
public record BankingRequest (@Nonnull Long userId, @Nonnull Long accountId, @Nonnull Long amount){ }
