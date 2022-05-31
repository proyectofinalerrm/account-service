package pe.com.bank.account.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transaction {

	private String transactionId;
	private double amount;
	private String date;
	private String type;
	private String accountNumber;
	private String creditId;

}
