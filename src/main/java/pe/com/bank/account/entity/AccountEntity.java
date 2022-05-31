package pe.com.bank.account.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="account")
public class AccountEntity {

	@Id
	private String id;
	private String accountNumber;
	private Double amount;
	private Date dateOpen;
	private String amounttype;	
	private Integer limitTr;
	private String productId;
	private String customerId;
	private String cardId;
	private String cardLabel;
	private Date cardAssociation;

}
