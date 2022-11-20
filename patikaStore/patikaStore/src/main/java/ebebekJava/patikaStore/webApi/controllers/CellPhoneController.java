package ebebekJava.patikaStore.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ebebekJava.patikaStore.business.abstracts.CellPhoneService;
import ebebekJava.patikaStore.business.requests.cellphone.CreateCellPhoneRequest;
import ebebekJava.patikaStore.business.requests.cellphone.DeleteCellPhoneRequest;
import ebebekJava.patikaStore.business.requests.cellphone.UpdateCellPhoneRequest;
import ebebekJava.patikaStore.business.responses.cellphone.GetAllCellPhoneResponse;
import ebebekJava.patikaStore.business.responses.cellphone.GetByIdCellPhoneResponse;

@RestController
@RequestMapping("/api/cellphones")
public class CellPhoneController {

	CellPhoneService cellPhoneService;

	@Autowired
	public CellPhoneController(CellPhoneService cellPhoneService) {
		super();
		this.cellPhoneService = cellPhoneService;
	}

	@PostMapping("/add")
	void add(CreateCellPhoneRequest createCellPhoneRequest) throws Exception {
		cellPhoneService.add(createCellPhoneRequest);
	}

	@DeleteMapping("/delete")
	void delete(DeleteCellPhoneRequest deleteCellPhoneRequest) {
		cellPhoneService.delete(deleteCellPhoneRequest);
	}

	@PutMapping("/update")
	void update(UpdateCellPhoneRequest updateCellPhoneRequest) {
		cellPhoneService.update(updateCellPhoneRequest);
	}

	@GetMapping("/getall")
	List<GetAllCellPhoneResponse> getAll() {
		return cellPhoneService.getAll();
	}

	@GetMapping("/getbyid")
	GetByIdCellPhoneResponse getById(int id) {
		return cellPhoneService.getById(id);
	}

}
