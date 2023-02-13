package co.com.bancolombia.demo.infraestructure.entrypoinst;

import co.com.bancolombia.demo.model.BankAccount;
import co.com.bancolombia.demo.usecase.BankAccountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ApiGraphQL {

    private final BankAccountUseCase bankAccountUseCase;

    @SchemaMapping(typeName = "Query", value = "getBankAccounts")
    public List<BankAccount> getBankAccount() {
        return bankAccountUseCase.getBankAccounts();
    }
}
