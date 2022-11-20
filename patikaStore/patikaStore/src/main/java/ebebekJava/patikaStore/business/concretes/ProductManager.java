package ebebekJava.patikaStore.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ebebekJava.patikaStore.business.abstracts.ProductService;
import ebebekJava.patikaStore.business.requests.product.CreateProductRequest;
import ebebekJava.patikaStore.business.requests.product.DeleteProductRequest;
import ebebekJava.patikaStore.business.requests.product.UpdateProductRequest;
import ebebekJava.patikaStore.business.responses.product.GetAllProductResponse;
import ebebekJava.patikaStore.business.responses.product.GetByIdProductResponse;
import ebebekJava.patikaStore.dataAccess.abstracts.BrandRepository;
import ebebekJava.patikaStore.dataAccess.abstracts.ProductRepository;
import ebebekJava.patikaStore.entities.concretes.Brand;
import ebebekJava.patikaStore.entities.concretes.Product;

@Service
public class ProductManager implements ProductService {

	private BrandRepository brandRepository;
	private ProductRepository productRepository;

	public ProductManager(BrandRepository brandRepository, ProductRepository productRepository) {
		super();
		this.brandRepository = brandRepository;
		this.productRepository = productRepository;
	}

	@Override
	public void add(CreateProductRequest createProductRequest) throws Exception {
		Product product = new Product();
		Brand brand = brandRepository.findById(createProductRequest.getBrandId()).get();
		product.setBrand(brand);
		product.setName(createProductRequest.getName());
		product.setUnitPrice(createProductRequest.getUnitPrice());
		product.setDiscountRate(createProductRequest.getDiscountRate());
		product.setUnitInStock(createProductRequest.getUnitInStock());
		productRepository.save(product);

	}

	@Override
	public void delete(DeleteProductRequest deleteProductRequest) {
		Product product = productRepository.findById(deleteProductRequest.getId()).get();
		productRepository.delete(product);

	}

	@Override
	public void update(UpdateProductRequest updateProductRequest) {
		Product product = productRepository.findById(updateProductRequest.getId()).get();
		Brand brand = brandRepository.findById(updateProductRequest.getBrandId()).get();
		product.setBrand(brand);
		product.setName(updateProductRequest.getName());
		product.setUnitPrice(updateProductRequest.getUnitPrice());
		product.setDiscountRate(updateProductRequest.getDiscountRate());
		product.setUnitInStock(updateProductRequest.getUnitInStock());
		productRepository.save(product);
		brandRepository.save(brand);

	}

	@Override
	public List<GetAllProductResponse> getAll() {
		List<Product> products = productRepository.findAll();
		List<GetAllProductResponse> productResponses = new ArrayList<GetAllProductResponse>();
		for (Product product : products) {
			GetAllProductResponse responseItem = new GetAllProductResponse();
			responseItem.setId(product.getId());
			responseItem.setName(product.getName());
			responseItem.setUnitPrice(product.getUnitPrice());
			responseItem.setDiscountRate(product.getDiscountRate());
			responseItem.setUnitInStock(product.getUnitInStock());
			responseItem.setBrandId(product.getBrand().getId());
			responseItem.setBrandName(product.getBrand().getName());

			productResponses.add(responseItem);
		}

		return productResponses;
	}

	@Override
	public GetByIdProductResponse getById(int id) {
		Optional<Product> product = productRepository.findById(id);
		GetByIdProductResponse responseItem = new GetByIdProductResponse();
		responseItem.setName(product.get().getName());
		return responseItem;
	}

}
