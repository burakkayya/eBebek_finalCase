package ebebekJava.patikaStore.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ebebekJava.patikaStore.business.abstracts.NotebookService;
import ebebekJava.patikaStore.business.requests.notebook.CreateNotebookRequest;
import ebebekJava.patikaStore.business.requests.notebook.DeleteNotebookRequest;
import ebebekJava.patikaStore.business.requests.notebook.UpdateNotebookRequest;
import ebebekJava.patikaStore.business.responses.notebook.GetAllNoteBookResponse;
import ebebekJava.patikaStore.business.responses.notebook.GetByIdNotebookResponse;

@RestController
@RequestMapping("/api/notebooks")
public class NotebookController {

	NotebookService notebookService;

	@Autowired
	public NotebookController(NotebookService notebookService) {
		super();
		this.notebookService = notebookService;
	}

	@PostMapping("/add")
	void add(CreateNotebookRequest createNotebookRequest) throws Exception {
		notebookService.add(createNotebookRequest);
	}

	@DeleteMapping("/delete")
	void delete(DeleteNotebookRequest deleteNotebookRequest) {
		notebookService.delete(deleteNotebookRequest);
	}

	@PutMapping("/update")
	void update(UpdateNotebookRequest updateNotebookRequest) {
		notebookService.update(updateNotebookRequest);
	}

	@GetMapping("/getall")
	List<GetAllNoteBookResponse> getAll() {
		return notebookService.getAll();
	}

	@GetMapping("/getbyid")
	GetByIdNotebookResponse getById(int id) {
		return notebookService.getById(id);
	}

}
