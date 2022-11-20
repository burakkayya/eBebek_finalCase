package ebebekJava.patikaStore.business.requests.cellphone;

import ebebekJava.patikaStore.business.requests.product.UpdateProductRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCellPhoneRequest extends UpdateProductRequest{

	private String memorySize;
	private String screenSize;
	private String ramSize;
	private String batterySize;
	private String colour;
}
