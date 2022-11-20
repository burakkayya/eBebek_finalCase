package ebebekJava.patikaStore.business.responses.notebook;

import ebebekJava.patikaStore.business.responses.product.GetAllProductResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllNoteBookResponse extends GetAllProductResponse{

	private String memorySize;
	private String screenSize;
	private String ramSize;
}
