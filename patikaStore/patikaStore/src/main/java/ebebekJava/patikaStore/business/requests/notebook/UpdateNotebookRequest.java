package ebebekJava.patikaStore.business.requests.notebook;

import ebebekJava.patikaStore.business.requests.product.UpdateProductRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateNotebookRequest extends UpdateProductRequest{

	private String memorySize;
	private String screenSize;
	private String ramSize;
}
