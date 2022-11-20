package ebebekJava.patikaStore.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ebebekJava.patikaStore.business.abstracts.BrandService;
import ebebekJava.patikaStore.business.requests.brand.CreateBrandRequest;
import ebebekJava.patikaStore.business.requests.brand.DeleteBrandRequest;
import ebebekJava.patikaStore.business.requests.brand.UpdateBrandRequest;
import ebebekJava.patikaStore.business.responses.brand.GetAllBrandResponse;
import ebebekJava.patikaStore.business.responses.brand.GetByIdBrandResponse;
import ebebekJava.patikaStore.dataAccess.abstracts.BrandRepository;
import ebebekJava.patikaStore.dataAccess.abstracts.ProductRepository;
import ebebekJava.patikaStore.dataAccess.abstracts.StoreRepository;
import ebebekJava.patikaStore.entities.concretes.Brand;
import ebebekJava.patikaStore.entities.concretes.Product;
import ebebekJava.patikaStore.entities.concretes.Store;

@Service
public class BrandManager implements BrandService {

	private StoreRepository storeRepository;
	private BrandRepository brandRepository;
	private ProductRepository productRepository;

	public BrandManager(StoreRepository storeRepository, BrandRepository brandRepository,
			ProductRepository productRepository) {
		super();
		this.storeRepository = storeRepository;
		this.brandRepository = brandRepository;
		this.productRepository = productRepository;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) throws Exception {
		Brand brand = new Brand();
		Store store = storeRepository.findById(createBrandRequest.getStoreId()).get();
		brand.setStore(store);
		brand.setName(createBrandRequest.getName());
		brandRepository.save(brand);

	}

	@Override
	public void delete(DeleteBrandRequest deleteBrandRequest) {
		Brand brand = brandRepository.findById(deleteBrandRequest.getId()).get();
		productRepository.deleteAll(brand.getProducts());
		brandRepository.delete(brand);

	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = brandRepository.findById(updateBrandRequest.getId()).get();
		Store store = storeRepository.findById(updateBrandRequest.getStoreId()).get();
		brand.setStore(store);
		brand.setName(updateBrandRequest.getName());
		brandRepository.save(brand);
	}

	@Override
	public List<GetAllBrandResponse> getAll() {
		List<Brand> brands = brandRepository.findAll();
		List<Product> products = productRepository.findAll();
		List<Store> stores = storeRepository.findAll();

		List<GetAllBrandResponse> brandResponses = new ArrayList<GetAllBrandResponse>();

		for (Brand brand : brands) {
			GetAllBrandResponse responseItem = new GetAllBrandResponse();
			for (Product product : products) {
				if (product.getBrand().getId() == brand.getId()) {
					if (!brand.getProducts().contains(product)) {
						brand.getProducts().add(product);
					}
				}
			}
			for (Store store : stores) {
				if (store.getId() == brand.getStore().getId()) {
					responseItem.setStoreId(brand.getStore().getId());
					responseItem.setStoreName(brand.getStore().getName());
				}
			}

			responseItem.setProducts(brand.getProducts());
			responseItem.setId(brand.getId());
			responseItem.setName(brand.getName());
			brandResponses.add(responseItem);
		}
		return brandResponses;
	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		Optional<Brand> brand = brandRepository.findById(id);
		GetByIdBrandResponse brandResponse = new GetByIdBrandResponse();
		brandResponse.setName(brand.get().getName());
		return brandResponse;
	}

}
