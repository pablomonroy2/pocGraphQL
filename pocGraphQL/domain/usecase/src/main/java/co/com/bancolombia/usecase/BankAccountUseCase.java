package co.com.bancolombia.usecase;

import co.com.bancolombia.model.BankAccount;
import co.com.bancolombia.model.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class BankAccountUseCase {
    private final BankAccountRepository bankAccountRepository;

    public BankAccount addBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.addBankAccount(bankAccount);
    }

    public BankAccount updateBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.updateBankAccount(bankAccount);
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccountRepository.getBankAccounts();
    }

    public Flux<List<BankAccount>> getFluxBankAccounts() {
        return bankAccountRepository.getFluxBankAccounts();
    }

    public List<BankAccount> getBankAccount(UUID id) {
        return bankAccountRepository.getBankAccount(id);
    }
}
