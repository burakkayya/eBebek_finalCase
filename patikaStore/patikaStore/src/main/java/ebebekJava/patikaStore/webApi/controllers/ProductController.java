package ebebekJava.patikaStore.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ebebekJava.patikaStore.business.abstracts.ProductService;
import ebebekJava.patikaStore.business.requests.product.CreateProductRequest;
import ebebekJava.patikaStore.business.requests.product.DeleteProductRequest;
import ebebekJava.patikaStore.business.requests.product.UpdateProductRequest;
import ebebekJava.patikaStore.business.responses.product.GetAllProductResponse;
import ebebekJava.patikaStore.business.responses.product.GetByIdProductResponse;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@PostMapping("/add")
	void add(CreateProductRequest createProductRequest) throws Exception {
		productService.add(createProductRequest);
	}

	@DeleteMapping("/delete")
	void delete(DeleteProductRequest deleteProductRequest) {
		productService.delete(deleteProductRequest);
	}

	@PutMapping("/update")
	void update(UpdateProductRequest updateProductRequest) {
		productService.update(updateProductRequest);
	}

	@GetMapping("/getall")
	List<GetAllProductResponse> getAll() {
		return productService.getAll();
	}

	@GetMapping("/getbyid")
	GetByIdProductResponse getById(int id) {
		return productService.getById(id);
	}

}
