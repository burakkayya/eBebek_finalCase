package ebebekJava.patikaStore.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ebebekJava.patikaStore.business.abstracts.BrandService;
import ebebekJava.patikaStore.business.requests.brand.CreateBrandRequest;
import ebebekJava.patikaStore.business.requests.brand.DeleteBrandRequest;
import ebebekJava.patikaStore.business.requests.brand.UpdateBrandRequest;
import ebebekJava.patikaStore.business.responses.brand.GetAllBrandResponse;
import ebebekJava.patikaStore.business.responses.brand.GetByIdBrandResponse;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

	BrandService brandService;

	@Autowired
	public BrandController(BrandService brandService) {
		super();
		this.brandService = brandService;
	}

	@PostMapping("/add")
	void add(CreateBrandRequest createBrandRequest) throws Exception {
		brandService.add(createBrandRequest);
	}

	@DeleteMapping("/delete")
	void delete(DeleteBrandRequest deleteBrandRequest) {
		brandService.delete(deleteBrandRequest);
	}

	@PutMapping("/update")
	void update(UpdateBrandRequest updateBrandRequest) {
		brandService.update(updateBrandRequest);
	}

	@GetMapping("/getall")
	List<GetAllBrandResponse> getAll() {
		return brandService.getAll();
	}

	@GetMapping("/getbyid")
	GetByIdBrandResponse getById(int id) {
		return brandService.getById(id);
	}

}
