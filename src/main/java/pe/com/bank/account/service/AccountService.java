package pe.com.bank.account.service;

import java.util.Date;
import org.springframework.stereotype.Service;
import pe.com.bank.account.dto.AccountCardDTO;
import pe.com.bank.account.dto.AccountTransactionDTO;
import pe.com.bank.account.dto.CurrentAccountValidateResponse;
import pe.com.bank.account.dto.OperationCard;
import pe.com.bank.account.dto.TransactionDTO;
import pe.com.bank.account.entity.AccountEntity;
import pe.com.bank.account.entity.MovementEntity;
import pe.com.bank.account.dto.RptAccountCard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {


	public Flux<AccountEntity> findAll();
	
	public Mono<AccountEntity> findById(String id);
	
	public Mono<AccountEntity> save(AccountEntity account);
		
	public Mono<Void> delete(AccountEntity account);
	
	public Flux<AccountEntity> getByCustomerId(String id);
	
	public Flux<AccountEntity> getByCustomerIdAndProductId(String customerId,String productId);

	public Mono<AccountEntity> updateAccount(AccountEntity updateAccount, String id);
	
	public Mono<CurrentAccountValidateResponse> validateCurrentAccount(String customerId,String accountId,Date date);
	
	public Flux<AccountEntity> getAccountByProductId (String productId);
		
	public Flux<AccountEntity> getAccounts();
	
	public Mono<AccountEntity> getAccountById(String id);

	public Mono<AccountEntity> newAccount(AccountEntity account);

	public Mono<Void> deleteAccountById(String id);

	public Mono<AccountEntity> getAccountByAccountNum(String accountNumber);

	public Mono<TransactionDTO> updateRestAmountByAccountId(MovementEntity movEntity);

	public Mono<TransactionDTO> updateSumAmountByAccountId( MovementEntity movEntity);

	public Mono<AccountTransactionDTO> retrieveAccountAndTransactionsByAccountId(String accountId);

	public Mono<AccountEntity> editAccount(AccountEntity account, String id);

	public Mono<AccountEntity> createAccountCard(AccountCardDTO accountCard);
	
	
	public Flux<AccountEntity> findAllByCardId(String id);

	public Mono<TransactionDTO> operationCard(OperationCard operationCard);

	public Mono<AccountEntity> operationCardAssociation(OperationCard operationCard);
	
	public Mono<AccountEntity> getSaldoCuentaPrincipalByCardId(RptAccountCard rptAccCard);	

}
