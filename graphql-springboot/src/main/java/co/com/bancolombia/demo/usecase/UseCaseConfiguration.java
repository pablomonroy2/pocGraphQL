package co.com.bancolombia.demo.usecase;

import co.com.bancolombia.demo.model.BankAccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public BankAccountUseCase bankAccountUseCase(BankAccountRepository bankAccountRepository) {
        return new BankAccountUseCase(bankAccountRepository);
    }
}
