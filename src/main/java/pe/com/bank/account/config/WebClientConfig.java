package pe.com.bank.account.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
public class WebClientConfig {
	
	private ReactorLoadBalancerExchangeFilterFunction lbFunction;

	
	@Bean
	@LoadBalanced
    public WebClient webClient(WebClient.Builder builder) {
		return builder.filter(lbFunction).build();
    }
	

}
