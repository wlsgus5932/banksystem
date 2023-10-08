package bank.per.banksystem.bank.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@Getter
@ToString
public class AccountGetResponse {
    private String number;
    private long balance;
    private String password;
    private int employeeId;
    private int branchId;
    private long customerId;
}
