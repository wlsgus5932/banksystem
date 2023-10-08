package bank.per.banksystem.employee;

import bank.per.banksystem.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee extends BaseEntity {
    @Id
    private long id;
    private String name;
    private long branchId;

}
