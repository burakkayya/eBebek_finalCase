package ebebekJava.patikaStore.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import ebebekJava.patikaStore.business.requests.product.CreateProductRequest;
import ebebekJava.patikaStore.business.requests.product.DeleteProductRequest;
import ebebekJava.patikaStore.business.requests.product.UpdateProductRequest;
import ebebekJava.patikaStore.business.responses.product.GetAllProductResponse;
import ebebekJava.patikaStore.business.responses.product.GetByIdProductResponse;

@Service
public interface ProductService {

	void add(CreateProductRequest createProductRequest) throws Exception;

	void delete(DeleteProductRequest deleteProductRequest);

	void update(UpdateProductRequest updateProductRequest);

	List<GetAllProductResponse> getAll();

	GetByIdProductResponse getById(int id);
}
