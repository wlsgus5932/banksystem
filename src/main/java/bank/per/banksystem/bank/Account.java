package bank.per.banksystem.bank;

import bank.per.banksystem.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account extends BaseEntity {
    @Id
    private String number;
    private String type;
    private long balance;
    private String password;
    private int employeeId;
    private int customerId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
