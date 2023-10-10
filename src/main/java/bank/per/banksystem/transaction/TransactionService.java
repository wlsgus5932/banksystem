package bank.per.banksystem.transaction;

import bank.per.banksystem.bank.Account;
import bank.per.banksystem.bank.AccountRepository;
import bank.per.banksystem.transaction.dto.TransferPostRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    /* 계좌 이체 트랜잭션 관리 */
    @Transactional
    public void transfer(TransferPostRequest request) {
        //출금내역기록
        Account withdrawAccount = accountRepository.findAccountByNumber(request.getRequestAccountNumber())
                .orElseThrow();
        long amount = withdrawAccount.getBalance();

        Transaction withdraw = Transaction.builder()
                .balance(request.getRequestAmount())
                .type("출금")
                .balanceAfterTransaction(amount - request.getRequestAmount())
                .accountNumber(request.getRequestAccountNumber())
                .build();

        transactionRepository.save(withdraw);

        //입금내역기록
        Account depositAccount = accountRepository.findAccountByNumber(request.getTargetAccountNumber())
                .orElseThrow();

        Transaction deposit = Transaction.builder()
                .balance(request.getTargetAmount())
                .type("입금")
                .balanceAfterTransaction(amount + request.getTargetAmount())
                .accountNumber(request.getTargetAccountNumber())
                .build();

        transactionRepository.save(deposit);

    }
}
