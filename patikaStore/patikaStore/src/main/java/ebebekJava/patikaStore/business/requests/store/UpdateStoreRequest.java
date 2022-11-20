package ebebekJava.patikaStore.business.requests.store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStoreRequest {

	private int id;
	private String name;
}
