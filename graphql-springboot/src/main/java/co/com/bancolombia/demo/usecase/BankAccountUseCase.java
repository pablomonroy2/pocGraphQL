package co.com.bancolombia.demo.usecase;

import co.com.bancolombia.demo.model.BankAccount;
import co.com.bancolombia.demo.model.BankAccountRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BankAccountUseCase {
    private final BankAccountRepository bankAccountRepository;

    public List<BankAccount> getBankAccounts() {
        return bankAccountRepository.getBankAccounts();
    }
}
