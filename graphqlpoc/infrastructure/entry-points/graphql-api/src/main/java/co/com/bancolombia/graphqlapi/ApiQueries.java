package co.com.bancolombia.graphqlapi;

import co.com.bancolombia.model.BankAccount;
import co.com.bancolombia.usecase.BankAccountUseCase;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Controller
/**
 * To interact with the API make use of Playground in the "/playground" path, but remember,
 * Playground ONLY must be used in dev or qa environments, not in production.
 */
public class ApiQueries implements GraphQLQueryResolver {

    private final BankAccountUseCase bankAccountUseCase;

    public List<BankAccount> getBankAccount(UUID id) {
        return bankAccountUseCase.getBankAccount(id);
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccountUseCase.getBankAccounts();
    }
}