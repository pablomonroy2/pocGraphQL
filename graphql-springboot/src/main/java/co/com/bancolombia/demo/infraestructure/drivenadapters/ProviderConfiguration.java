package co.com.bancolombia.demo.infraestructure.drivenadapters;

import co.com.bancolombia.demo.model.BankAccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProviderConfiguration {

    @Bean
    public BankAccountRepository bankAccountRepository() {
        return new Provider();
    }
}
