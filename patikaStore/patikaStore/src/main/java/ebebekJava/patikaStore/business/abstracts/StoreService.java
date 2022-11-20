package ebebekJava.patikaStore.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import ebebekJava.patikaStore.business.requests.store.CreateStoreRequest;
import ebebekJava.patikaStore.business.requests.store.DeleteStoreRequest;
import ebebekJava.patikaStore.business.requests.store.UpdateStoreRequest;
import ebebekJava.patikaStore.business.responses.store.GetAllStoreResponse;
import ebebekJava.patikaStore.business.responses.store.GetByIdStoreResponse;

@Service
public interface StoreService {

	void add(CreateStoreRequest createStoreRequest) throws Exception;

	void delete(DeleteStoreRequest deleteStoreRequest);

	void update(UpdateStoreRequest updateStoreRequest);

	List<GetAllStoreResponse> getAll();

	GetByIdStoreResponse getById(int id);
}
