package co.com.bancolombia.model;

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