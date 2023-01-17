package co.com.bancolombia.graphqlapi;

import co.com.bancolombia.model.BankAccount;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.FluxProcessor;
import reactor.core.publisher.FluxSink;

import java.util.List;
@Slf4j
@Component
public class BankAccountPublisher {

    private final FluxProcessor<List<BankAccount>, List<BankAccount>> processor;
    private final FluxSink<List<BankAccount>> sink;

    public BankAccountPublisher() {
        this.processor = DirectProcessor.<List<BankAccount>>create().serialize();
        this.sink = processor.sink();
    }

    public void publish(List<BankAccount> bankAccount) {
        sink.next(bankAccount);
    }

    public Publisher<List<BankAccount>> getBankAccountPublisher() {
        return processor.map(bankAccount -> {
            log.info("Publishing subscription update for bank Account {}", bankAccount);
            return bankAccount;
        });
    }
}
