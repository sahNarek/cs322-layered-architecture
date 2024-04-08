package banking.model;

import jakarta.persistence.*;
import am.cs322.model.User;

//import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "\"bank_account\"", uniqueConstraints = @UniqueConstraint(columnNames = {"\"bank_name\"", "\"account_number\"", "\"currentBalance\""}))
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Account() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name="\"user_id\"")
    private User user;

    @Column(name = "\"bank_name\"")
    private String bankName;


    @Column(name = "\"account_number\"")
    private String accountNumber;

    @Column(name = "\"currentBalance\"")
    private Long currentBalance;

    @Column(name = "\"credit_limit\"")
    private Long creditLimit;

    public Account(String bankName, String accountNumber, Long currentBalance, Long creditLimit, User user) {
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.creditLimit = creditLimit;
        this.user = user;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(bankName, account.bankName) &&
                Objects.equals(accountNumber, account.accountNumber) &&
                Objects.equals(currentBalance, account.currentBalance) &&
                Objects.equals(creditLimit, account.creditLimit) &&
                user.equals(account.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankName, accountNumber, currentBalance, creditLimit, user);
    }

    public Boolean debit(Long amount) {
        return amount <= currentBalance;
    }

    public Boolean credit(Long amount) {
        if (amount <= creditLimit){
            this.creditLimit -=amount;
            return  true;
        }
        return  false;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Long getCurrentBalance() {
        return currentBalance;
    }

    public String getBankName() {
        return bankName;
    }

    public Long getCreditLimit() {
        return creditLimit;
    }
}


