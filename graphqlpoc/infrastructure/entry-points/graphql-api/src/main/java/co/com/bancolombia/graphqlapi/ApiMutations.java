package co.com.bancolombia.graphqlapi;

import co.com.bancolombia.model.BankAccount;
import co.com.bancolombia.usecase.BankAccountUseCase;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
/**
* To interact with the API make use of Playground in the "/playground" path, but remember,
* Playground ONLY must be used in dev or qa environments, not in production.
*/
public class ApiMutations implements GraphQLMutationResolver {

    private final BankAccountUseCase bankAccountUseCase;
    private final BankAccountPublisher bankAccountPublisher;

    public BankAccount addBankAccount(BankAccount bankAccount) {
        return bankAccountUseCase.addBankAccount(bankAccount);
    }

    public BankAccount updateBankAccount(BankAccount bankAccount) {
        bankAccountUseCase.updateBankAccount(bankAccount);
        bankAccountPublisher.publish(bankAccountUseCase.getBankAccounts());
        return bankAccount;
    }
}