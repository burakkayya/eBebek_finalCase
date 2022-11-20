package ebebekJava.patikaStore.business.responses.brand;

import java.util.List;

import ebebekJava.patikaStore.entities.concretes.Product;
import ebebekJava.patikaStore.entities.concretes.Store;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBrandResponse {

	private int id;
	private String name;
	private int storeId;
	private String storeName;
	private List<Product> products;
}
