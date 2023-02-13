package co.com.bancolombia.demo.infraestructure.drivenadapters;

import co.com.bancolombia.demo.model.AccountType;
import co.com.bancolombia.demo.model.BankAccount;
import co.com.bancolombia.demo.model.BankAccountRepository;
import co.com.bancolombia.demo.model.Currency;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

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

    public List<BankAccount> getBankAccounts() {
        return bankAccountList;
    }

}
