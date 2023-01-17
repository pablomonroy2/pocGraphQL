package co.com.bancolombia.model;
import reactor.core.publisher.Flux;
import java.util.List;
import java.util.UUID;

public interface BankAccountRepository {
    BankAccount addBankAccount(BankAccount parameter);
    BankAccount updateBankAccount(BankAccount parameter);
    List<BankAccount> getBankAccounts();
    Flux<List<BankAccount>> getFluxBankAccounts();
    List<BankAccount> getBankAccount(UUID id);
}
