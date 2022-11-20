package ebebekJava.patikaStore.business.requests.notebook;

import ebebekJava.patikaStore.business.requests.product.CreateProductRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateNotebookRequest extends CreateProductRequest{

	private String memorySize;
	private String screenSize;
	private String ramSize;
}
