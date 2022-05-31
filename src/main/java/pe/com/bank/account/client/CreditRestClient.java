package pe.com.bank.account.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import pe.com.bank.account.client.entity.TransactionEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CreditRestClient {
	
	
	  private WebClient webClient;		
	  
	  public CreditRestClient(WebClient webClient) {
	        this.webClient = webClient;
	    }
	  
	  
	  @Value("${restClient.creditUrl}")
	  private String creditUrl;
	  
	  public Mono<Long> getCountByCustomerIdAndProductId(String customerId,String productId){
		  
		  var url = creditUrl.concat("/v1/credits/{customerId}/{productId}");
		  
		  return  webClient
	                .get()
	                .uri(url,customerId,productId)
	                .retrieve()
	                .bodyToMono(Long.class)
	                .log();

	  }  
	  
	  
	  public Flux<TransactionEntity> getCreditByCustomerId(String customerId){
		  
		  var url = creditUrl.concat("/{id}");
		  
		  return  webClient
	                .get()
	                .uri(url,customerId)
	                .retrieve()
	                .bodyToFlux(TransactionEntity.class)
	                .log();

	  }

}
