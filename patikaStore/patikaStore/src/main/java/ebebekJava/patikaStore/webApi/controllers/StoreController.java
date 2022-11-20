package ebebekJava.patikaStore.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ebebekJava.patikaStore.business.abstracts.StoreService;
import ebebekJava.patikaStore.business.requests.store.CreateStoreRequest;
import ebebekJava.patikaStore.business.requests.store.DeleteStoreRequest;
import ebebekJava.patikaStore.business.requests.store.UpdateStoreRequest;
import ebebekJava.patikaStore.business.responses.store.GetAllStoreResponse;
import ebebekJava.patikaStore.business.responses.store.GetByIdStoreResponse;

@RestController
@RequestMapping("/api/stores")
public class StoreController {

	private StoreService storeService;

	@Autowired
	public StoreController(StoreService storeService) {
		super();
		this.storeService = storeService;
	}

	@PostMapping("/add")
	void add(CreateStoreRequest createStoreRequest) throws Exception {
		storeService.add(createStoreRequest);
	}

	@DeleteMapping("/delete")
	void delete(DeleteStoreRequest deleteStoreRequest) {
		storeService.delete(deleteStoreRequest);
	}

	@PutMapping("/update")
	void update(UpdateStoreRequest updateStoreRequest) {
		storeService.update(updateStoreRequest);
	}

	@GetMapping("/getall")
	List<GetAllStoreResponse> getAll() {
		return storeService.getAll();
	}

	@GetMapping("/getbyid")
	GetByIdStoreResponse getById(int id) {
		return storeService.getById(id);
	}

}
