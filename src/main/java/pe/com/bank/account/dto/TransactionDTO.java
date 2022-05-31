package pe.com.bank.account.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {

	//private String transactionId;
	private double amount;
	private Date date;
	private String type;
	private String accountId;
	private Double commissionTr;
}
