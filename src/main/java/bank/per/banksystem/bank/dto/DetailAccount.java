package bank.per.banksystem.bank.dto;

import bank.per.banksystem.transaction.Transaction;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@ToString
public class DetailAccount {
    private String accountNumber;
    private String accountType;
    private String accountName;
    private long accountAmount;
    private List<Transaction> depositAndWithdrawaHistory;
}
