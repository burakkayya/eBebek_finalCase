package ebebekJava.patikaStore.business.responses.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductResponse {

	private int id;
	private String name;
	private float unitPrice;
	private float discountRate;
	private int unitInStock;
	private int brandId;
	private String brandName;
}
