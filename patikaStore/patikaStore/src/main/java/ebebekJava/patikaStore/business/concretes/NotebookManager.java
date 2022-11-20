package ebebekJava.patikaStore.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ebebekJava.patikaStore.business.abstracts.NotebookService;
import ebebekJava.patikaStore.business.requests.notebook.CreateNotebookRequest;
import ebebekJava.patikaStore.business.requests.notebook.DeleteNotebookRequest;
import ebebekJava.patikaStore.business.requests.notebook.UpdateNotebookRequest;
import ebebekJava.patikaStore.business.responses.notebook.GetAllNoteBookResponse;
import ebebekJava.patikaStore.business.responses.notebook.GetByIdNotebookResponse;
import ebebekJava.patikaStore.dataAccess.abstracts.BrandRepository;
import ebebekJava.patikaStore.dataAccess.abstracts.NotebookRepository;
import ebebekJava.patikaStore.dataAccess.abstracts.ProductRepository;
import ebebekJava.patikaStore.entities.concretes.Brand;
import ebebekJava.patikaStore.entities.concretes.Notebook;

@Service
public class NotebookManager implements NotebookService {

	private BrandRepository brandRepository;
	private ProductRepository productRepository;
	private NotebookRepository notebookRepository;

	@Autowired
	public NotebookManager(BrandRepository brandRepository, ProductRepository productRepository,
			NotebookRepository notebookRepository) {
		super();
		this.brandRepository = brandRepository;
		this.productRepository = productRepository;
		this.notebookRepository = notebookRepository;
	}

	@Override
	public void add(CreateNotebookRequest createNotebookRequest) throws Exception {
		Notebook notebook = new Notebook();
		Brand brand = brandRepository.findById(createNotebookRequest.getBrandId()).get();
		notebook.setBrand(brand);
		notebook.setName(createNotebookRequest.getName());
		notebook.setUnitPrice(createNotebookRequest.getUnitPrice());
		notebook.setDiscountRate(createNotebookRequest.getDiscountRate());
		notebook.setUnitInStock(createNotebookRequest.getUnitInStock());
		notebook.setMemorySize(createNotebookRequest.getMemorySize());
		notebook.setRamSize(createNotebookRequest.getRamSize());
		notebook.setScreenSize(createNotebookRequest.getScreenSize());
		productRepository.save(notebook);
		notebookRepository.save(notebook);

	}

	@Override
	public void delete(DeleteNotebookRequest deleteNotebookRequest) {
		Notebook notebook = notebookRepository.findById(deleteNotebookRequest.getId()).get();
		notebookRepository.delete(notebook);
		productRepository.delete(notebook);

	}

	@Override
	public void update(UpdateNotebookRequest updateNotebookRequest) {
		Notebook notebook = notebookRepository.findById(updateNotebookRequest.getId()).get();
		Brand brand = brandRepository.findById(updateNotebookRequest.getBrandId()).get();
		notebook.setBrand(brand);
		notebook.setName(updateNotebookRequest.getName());
		notebook.setUnitPrice(updateNotebookRequest.getUnitPrice());
		notebook.setDiscountRate(updateNotebookRequest.getDiscountRate());
		notebook.setUnitInStock(updateNotebookRequest.getUnitInStock());
		notebook.setMemorySize(updateNotebookRequest.getMemorySize());
		notebook.setRamSize(updateNotebookRequest.getRamSize());
		notebook.setScreenSize(updateNotebookRequest.getScreenSize());
		notebookRepository.save(notebook);
		productRepository.save(notebook);
		brandRepository.save(brand);

	}

	@Override
	public List<GetAllNoteBookResponse> getAll() {
		List<Notebook> notebooks = notebookRepository.findAll();
		List<GetAllNoteBookResponse> notebookResponses = new ArrayList<GetAllNoteBookResponse>();
		for (Notebook notebook : notebooks) {
			GetAllNoteBookResponse responseItem = new GetAllNoteBookResponse();
			responseItem.setId(notebook.getId());
			responseItem.setName(notebook.getName());
			responseItem.setUnitPrice(notebook.getUnitPrice());
			responseItem.setDiscountRate(notebook.getDiscountRate());
			responseItem.setUnitInStock(notebook.getUnitInStock());
			responseItem.setBrandId(notebook.getBrand().getId());
			responseItem.setBrandName(notebook.getBrand().getName());
			responseItem.setMemorySize(notebook.getMemorySize());
			responseItem.setRamSize(notebook.getRamSize());
			responseItem.setScreenSize(notebook.getScreenSize());

			notebookResponses.add(responseItem);
		}

		return notebookResponses;
	}

	@Override
	public GetByIdNotebookResponse getById(int id) {
		Optional<Notebook> notebook = notebookRepository.findById(id);
		GetByIdNotebookResponse responseItem = new GetByIdNotebookResponse();
		responseItem.setName(notebook.get().getName());
		return responseItem;
	}

}
