package pe.com.bank.account.dto;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.bank.account.entity.DebitCardEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountCardDTO {

	private String id;
	private String accountNumber;
	private Double amount;
	private Date dateOpen;
	private String amounttype;	
	private int limitTr;
	private String productId;
	private String customerId;
	private String cardId;
	private String cardLabel;
	private Date cardAssociation;
	private DebitCardEntity debitCardEntity;
	
	
}
