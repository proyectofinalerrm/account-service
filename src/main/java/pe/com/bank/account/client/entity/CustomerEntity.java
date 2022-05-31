package pe.com.bank.account.client.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {
	
	private String id;
	private String customerType;
	private String dateAssociated;
	private String category;

}
