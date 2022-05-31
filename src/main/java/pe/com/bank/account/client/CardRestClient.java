package pe.com.bank.account.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


import pe.com.bank.account.entity.DebitCardEntity;
import reactor.core.publisher.Mono;

@Component
public class CardRestClient {

	  private WebClient webClient;	
	  
	  public CardRestClient(WebClient webClient) {
		  this.webClient = webClient;
	  }
	  
	  @Value("${restClient.debitCardUrl}")
	  private String debitCardUrl;
	    
	  
	  public Mono<DebitCardEntity> createDebitCard(DebitCardEntity debitCard) {
	        var url = debitCardUrl.concat("/v1/createDebitCard");
	        return webClient.post()
	                .uri(url)
	                .body(Mono.just(debitCard), DebitCardEntity.class)
	                .retrieve()
	                .bodyToMono(DebitCardEntity.class);
	    }
	  
}
