package pe.com.bank.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.bank.account.entity.Transaction;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountTransactionDTO {

	private String account_id;
	private String accountNumber;
	private double amount;
	private Date dateOpen;
	private String amounttype;
	private List<Transaction> transactionList;
}
