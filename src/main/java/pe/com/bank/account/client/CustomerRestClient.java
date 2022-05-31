package pe.com.bank.account.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import pe.com.bank.account.client.entity.CustomerEntity;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Value;

@Component
public class CustomerRestClient {
	
	
	  private WebClient webClient;		
	  
	  public CustomerRestClient(WebClient webClient) {
	        this.webClient = webClient;
	    }
	  
	  
	  @Value("${restClient.customerUrl}")
	  private String customerUrl;
	  
	  public Mono<CustomerEntity> getCustomer(String customerId){
		  
		  var url = customerUrl.concat("/{id}");
		  
		  return  webClient
	                .get()
	                .uri(url,customerId)
	                .retrieve()
	                .bodyToMono(CustomerEntity.class)
	                .log();
  
	  }  
	  
}
