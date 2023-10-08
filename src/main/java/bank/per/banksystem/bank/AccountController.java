package bank.per.banksystem.bank;

import bank.per.banksystem.bank.dto.AccountGetResponse;
import bank.per.banksystem.bank.dto.DetailAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/accounts") // TODO: header -> customer_id
    public ResponseEntity<List<AccountGetResponse>> getAccounts(@RequestParam long customerId) {
        return ResponseEntity.ok(accountService.getAccounts(customerId));
    }

    @GetMapping("/account/{accountNumber}/detail")
    public ResponseEntity<DetailAccount> getAccountDetail(@PathVariable String accountNumber,
                                                          @RequestParam long customerId,
                                                          @RequestParam LocalDateTime viewYearMonth) {

        //TODO: customer_id 검증
        return ResponseEntity.ok(accountService.getAccountDetail(accountNumber, viewYearMonth));
    }
}
