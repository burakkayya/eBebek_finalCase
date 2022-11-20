package ebebekJava.patikaStore.business.responses.cellphone;

import ebebekJava.patikaStore.business.responses.product.GetAllProductResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCellPhoneResponse extends GetAllProductResponse{

	private String memorySize;
	private String screenSize;
	private String ramSize;
	private String batterySize;
	private String colour;
}
