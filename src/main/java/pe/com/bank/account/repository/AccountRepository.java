package pe.com.bank.account.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import pe.com.bank.account.entity.AccountEntity;
import pe.com.bank.account.entity.DebitCardEntity;


@Repository
public interface AccountRepository extends ReactiveMongoRepository<AccountEntity,String>{
	
   Flux<AccountEntity> findByCustomerId(String id);
  
   Flux<AccountEntity> findByCustomerIdAndProductId(String customerId,String productId);
  	
   Mono<Long> countByCustomerIdAndProductId(String customerId,String productId);
  	
   Flux<AccountEntity> findByProductId(String productId);
  	
   Mono<AccountEntity> findAccountsByAccountNumber(String accountNumber);
   
   Flux<AccountEntity> findByCardId (String cardId);

   Mono<AccountEntity> findByCardIdAndCardLabel(String cardId,String cp);
	
   Mono<AccountEntity> findAccountEntitiesByCardIdAndCardLabel(String cardId, String cardLabel); 
}
