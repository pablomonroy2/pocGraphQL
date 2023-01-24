package co.com.bancolombia.api;
import co.com.bancolombia.model.BankAccount;
import co.com.bancolombia.usecase.BankAccountUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final BankAccountUseCase bankAccountUseCase;
    @GetMapping(path = "/bank-accounts")
    public List<BankAccount> getBankAccounts() {
        return bankAccountUseCase.getBankAccounts();
    }

    @GetMapping(path = "/bank-account/{id}")
    public List<BankAccount> getBankAccount(@PathVariable UUID id) {
        return bankAccountUseCase.getBankAccount(id);
    }

    @PostMapping(path = "/add-account")
    @ResponseBody
    public BankAccount addBankAccount(@RequestBody BankAccount bankAccount) {
        return bankAccountUseCase.addBankAccount(bankAccount);
    }

    @PostMapping(path = "/update-account")
    @ResponseBody
    public BankAccount updateBankAccount(@RequestBody BankAccount bankAccount) {
        return bankAccountUseCase.updateBankAccount(bankAccount);
    }

}
