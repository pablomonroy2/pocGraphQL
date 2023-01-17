package co.com.bancolombia.graphqlapi;

import co.com.bancolombia.model.BankAccount;
import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
/**
 * To interact with the API make use of Playground in the "/playground" path, but remember,
 * Playground ONLY must be used in dev or qa environments, not in production.
 */
public class ApiSubscriptions implements GraphQLSubscriptionResolver {

    private final BankAccountPublisher publisher;

    public  Publisher<List<BankAccount>> bankAccountStatus() {
        return publisher.getBankAccountPublisher();    }

}