package pe.com.bank.account.client;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import pe.com.bank.account.client.entity.TransactionEntity;
import pe.com.bank.account.dto.TransactionDTO;
import pe.com.bank.account.entity.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class TransactionRestClient {

    private WebClient webClient;

    public TransactionRestClient(WebClient webClient) {
        this.webClient = webClient;
    }

    @Value("${restClient.transactionUrl}")
    private String transactionUrl;

    public Flux<TransactionEntity> getTransactionsByDate(String idCustomer, String accountId, Date date) {

        var url = transactionUrl.concat("/{id}");

        return webClient
                .get()
                .uri(url, idCustomer)
                .retrieve()
                .bodyToFlux(TransactionEntity.class)
                .log();

    }


    public Flux<Transaction> retrieveTransaction(String accountNumber) {

        var url = transactionUrl.concat("/v1/transactions/account/{id}");
        return webClient
                .get()
                .uri(url, accountNumber)
                .retrieve()
                .bodyToFlux(Transaction.class);
    }


    public Mono<TransactionDTO> createTransactionUpdate(TransactionDTO transaction) {
        var url = transactionUrl.concat("/v1/transactions/amountUpdate");
        return webClient.post()
                .uri(url)
                .body(Mono.just(transaction), TransactionDTO.class)
                .retrieve()
                .bodyToMono(TransactionDTO.class);
    }

    public Mono<Long> contTransactionByType(String typ, String accountI) {
        return webClient.get().uri(uriBuilder -> uriBuilder.scheme("http")
                        .host("gateway-server-service")
                        .path("/api/transaction/v1/transaction/count")
                        .queryParam("accountId", accountI)
                        .queryParam("typ", typ)
                        .build())
                .retrieve()
                .bodyToMono(Long.class);
    }


}
