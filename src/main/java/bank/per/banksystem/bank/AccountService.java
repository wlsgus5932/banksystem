package bank.per.banksystem.bank;

import bank.per.banksystem.bank.dto.AccountGetResponse;
import bank.per.banksystem.bank.dto.DetailAccount;
import bank.per.banksystem.transaction.Transaction;
import bank.per.banksystem.transaction.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public List<AccountGetResponse> getAccounts(long customerId) {
        return accountRepository.findAccountByCustomerId(customerId)
                .stream().map(account -> AccountGetResponse.builder()
                        .number(account.getNumber())
                        .balance(account.getBalance())
                        .branchId(account.getBranchId())
                        .customerId(account.getCustomerId())
                        .build())
                .toList();
    }

    public DetailAccount getAccountDetail(String accountNumber, LocalDateTime viewYearMonth) {
        Account account = accountRepository.findAccountByNumber(accountNumber).orElseThrow();
        LocalDateTime startDate = viewYearMonth.plusDays(1);
        LocalDateTime endDate = viewYearMonth.plusMonths(1).minusDays(1);
        List<Transaction> transactionList = transactionRepository.findByAccountNumberAndCreatedAtBetween(accountNumber, startDate, endDate);

        return DetailAccount.builder()
                .accountNumber(account.getNumber())
                .accountType(account.getType())
                .accountAmount(account.getBalance())
                .depositAndWithdrawaHistory(transactionList)
                .build();
    }


}
