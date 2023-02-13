package co.com.bancolombia.demo.model;

import co.com.bancolombia.demo.model.AccountType;
import lombok.*;

import java.util.UUID;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class BankAccount {
    UUID id;
    String userName;
    Currency currency;
    Float balance;
    AccountType accountType;
}