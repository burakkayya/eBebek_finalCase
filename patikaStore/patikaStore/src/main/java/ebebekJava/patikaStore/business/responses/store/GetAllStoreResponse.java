package ebebekJava.patikaStore.business.responses.store;

import java.util.List;

import ebebekJava.patikaStore.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllStoreResponse {

	private int id;
	private String name;
	private List<Brand> brands;
	
}
