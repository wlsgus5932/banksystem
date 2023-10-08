package bank.per.banksystem.bank;

import bank.per.banksystem.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Account extends BaseEntity {
    @Id
    private String number;
    private String type;
    private boolean isFirst;
    private long balance;
    private String password;
    private int employeeId;
    private int branchId;
    private long customerId;

}
