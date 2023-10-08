package bank.per.banksystem.bank;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    void test() {
        Account account = Account.builder()
                .number("111")
                .balance(10000)
                .build();


    }
}
