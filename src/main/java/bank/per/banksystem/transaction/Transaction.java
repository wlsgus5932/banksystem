package bank.per.banksystem.transaction;

import bank.per.banksystem.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Transaction extends BaseEntity {
    @Id
    private long id;
    private long balance;
    private String type;
    private long balanceAfterTransaction;
    private String accountNumber;
}
