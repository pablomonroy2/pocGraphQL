package co.com.bancolombia.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ApiGraphQL {

    private final Provider bankAccountUseCase;

    /*@QueryMapping
    public List<BankAccount> getBankAccount(@Argument UUID id) {
        return bankAccountUseCase.getBankAccount(id);
    }*/

    @SchemaMapping(typeName = "Query", value = "getBankAccounts")
    public List<BankAccount> getBankAccount(@Argument UUID id) {
        return bankAccountUseCase.getBankAccounts();
    }
}
