package co.com.bancolombia.demo;

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