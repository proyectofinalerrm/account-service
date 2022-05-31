package pe.com.bank.account.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DebitCardEntity {

	private String cardId;
	private Long numberCard;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date openingDate;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dueDate;
	private Integer cvv;
	private String onlinePayment;
	private String customerId;
}
