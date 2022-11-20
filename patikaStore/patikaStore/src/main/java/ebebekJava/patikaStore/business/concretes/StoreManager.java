package ebebekJava.patikaStore.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ebebekJava.patikaStore.business.abstracts.StoreService;
import ebebekJava.patikaStore.business.requests.store.CreateStoreRequest;
import ebebekJava.patikaStore.business.requests.store.DeleteStoreRequest;
import ebebekJava.patikaStore.business.requests.store.UpdateStoreRequest;
import ebebekJava.patikaStore.business.responses.store.GetAllStoreResponse;
import ebebekJava.patikaStore.business.responses.store.GetByIdStoreResponse;
import ebebekJava.patikaStore.dataAccess.abstracts.BrandRepository;
import ebebekJava.patikaStore.dataAccess.abstracts.ProductRepository;
import ebebekJava.patikaStore.dataAccess.abstracts.StoreRepository;
import ebebekJava.patikaStore.entities.concretes.Brand;
import ebebekJava.patikaStore.entities.concretes.Store;

@Service
public class StoreManager implements StoreService {

	private StoreRepository storeRepository;
	private BrandRepository brandRepository;
	private ProductRepository productRepository;

	@Autowired
	public StoreManager(StoreRepository storeRepository, BrandRepository brandRepository,
			ProductRepository productRepository) {
		super();
		this.storeRepository = storeRepository;
		this.brandRepository = brandRepository;
		this.productRepository = productRepository;
	}

	@Override
	public void add(CreateStoreRequest createStoreRequest) throws Exception {
		Store store = new Store();
		store.setName(createStoreRequest.getName());
		storeRepository.save(store);
	}

	@Override
	public void delete(DeleteStoreRequest deleteStoreRequest) {
		Store store = storeRepository.findById(deleteStoreRequest.getId()).get();

		productRepository.deleteAll();
		brandRepository.deleteAll(store.getBrands());
		storeRepository.delete(store);

	}

	@Override
	public void update(UpdateStoreRequest updateStoreRequest) {
		Store store = storeRepository.findById(updateStoreRequest.getId()).get();
		store.setName(updateStoreRequest.getName());
		storeRepository.save(store);

	}

	@Override
	public List<GetAllStoreResponse> getAll() {
		List<Store> stores = storeRepository.findAll();
		List<Brand> brands = brandRepository.findAll();

		List<GetAllStoreResponse> storeResponses = new ArrayList<GetAllStoreResponse>();

		for (Store store : stores) {
			GetAllStoreResponse responseItem = new GetAllStoreResponse();
			for (Brand brand : brands) {
				if (brand.getStore().getId() == store.getId()) {
					if (!store.getBrands().contains(brand)) {
						store.getBrands().add(brand);
					}
				}
			}
			responseItem.setBrands(store.getBrands());
			responseItem.setId(store.getId());
			responseItem.setName(store.getName());
			storeResponses.add(responseItem);
		}

		return storeResponses;
	}

	@Override
	public GetByIdStoreResponse getById(int id) {
		Optional<Store> store = storeRepository.findById(id);
		GetByIdStoreResponse storeResponse = new GetByIdStoreResponse();
		storeResponse.setName(store.get().getName());
		return storeResponse;
	}

}
