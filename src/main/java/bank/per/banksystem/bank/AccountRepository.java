package bank.per.banksystem.bank;

import bank.per.banksystem.bank.dto.AccountGetResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {
    List<AccountGetResponse> findAccountByCustomerId(long customerId);
    Optional<Account> findAccountByNumber(String accountNumber);
}
