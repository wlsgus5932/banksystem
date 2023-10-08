package bank.per.banksystem.customer.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CustomerException extends Exception {
    private final long id;
    private final String name;
}
