package bank.per.banksystem.customer;

import bank.per.banksystem.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Customer extends BaseEntity {
    @Id
    private long id;
    private String name;
    private String grade;
    private int age;
    private String email;
    private String organization;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
