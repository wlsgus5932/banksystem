package bank.per.banksystem.transaction;

import bank.per.banksystem.transaction.dto.TransferPostRequest;
import bank.per.banksystem.transaction.dto.TransferPostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/transfer")
    public ResponseEntity<TransferPostResponse> transfer(@RequestBody TransferPostRequest request) {
        transactionService.transfer(request);
        return ResponseEntity.ok(TransferPostResponse.builder()
                .resultCode("정상 처리 되었습니다.")
                .resultMessage("00")
                .build());
    }
}
