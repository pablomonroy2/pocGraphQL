package co.com.bancolombia.provider;

import co.com.bancolombia.model.AccountType;
import co.com.bancolombia.model.BankAccount;
import co.com.bancolombia.model.BankAccountRepository;
import co.com.bancolombia.model.Currency;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class Provider implements BankAccountRepository {
    List<BankAccount> bankAccountList;

    public Provider() {
        this.bankAccountList = new LinkedList<>();
        for (int i = 1; i < 51; i++) {
            boolean sw = i % 2 == 0;
            bankAccountList.add(BankAccount.builder().id(UUID.randomUUID())
                    .userName("user name ".concat(String.valueOf(i)))
                    .accountType(sw ? AccountType.AHORROS : AccountType.CORRIENTE)
                    .balance(sw ? (i * 100f) : (i * 10000f))
                    .currency(sw ? Currency.USD : Currency.COP)
                    .build());
        }
    }

    @Override
    public BankAccount addBankAccount(BankAccount bankAccount) {
        bankAccountList.add(bankAccount);
        return bankAccount;
    }

    @Override
    public BankAccount updateBankAccount(BankAccount bankAccount) {
        bankAccountList.removeIf(b -> b.getId().equals(bankAccount.getId()));
        bankAccountList.add(bankAccount);
        return bankAccount;
    }

    @Override
    public List<BankAccount> getBankAccounts() {
        return bankAccountList;
    }

    @Override
    public Flux<List<BankAccount>> getFluxBankAccounts() {
        return Flux.just(bankAccountList);
    }

    @Override
    public List<BankAccount> getBankAccount(UUID id) {
        return bankAccountList.stream().filter(b -> b.getId().equals(id)).collect(Collectors.toList());
    }
}
