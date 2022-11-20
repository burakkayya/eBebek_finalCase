package ebebekJava.patikaStore.business.requests.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {

	private String name;
	private float unitPrice;
	private float discountRate;
	private int unitInStock;
	private int brandId;
}
