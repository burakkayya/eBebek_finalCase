package ebebekJava.patikaStore.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ebebekJava.patikaStore.business.abstracts.CellPhoneService;
import ebebekJava.patikaStore.business.requests.cellphone.CreateCellPhoneRequest;
import ebebekJava.patikaStore.business.requests.cellphone.DeleteCellPhoneRequest;
import ebebekJava.patikaStore.business.requests.cellphone.UpdateCellPhoneRequest;
import ebebekJava.patikaStore.business.responses.cellphone.GetAllCellPhoneResponse;
import ebebekJava.patikaStore.business.responses.cellphone.GetByIdCellPhoneResponse;
import ebebekJava.patikaStore.dataAccess.abstracts.BrandRepository;
import ebebekJava.patikaStore.dataAccess.abstracts.CellPhoneRepository;
import ebebekJava.patikaStore.dataAccess.abstracts.ProductRepository;
import ebebekJava.patikaStore.entities.concretes.Brand;
import ebebekJava.patikaStore.entities.concretes.CellPhone;

@Service
public class CellPhoneManager implements CellPhoneService {

	private BrandRepository brandRepository;
	private ProductRepository productRepository;
	private CellPhoneRepository cellPhoneRepository;

	@Autowired
	public CellPhoneManager(BrandRepository brandRepository, ProductRepository productRepository,
			CellPhoneRepository cellPhoneRepository) {
		super();
		this.brandRepository = brandRepository;
		this.productRepository = productRepository;
		this.cellPhoneRepository = cellPhoneRepository;
	}

	@Override
	public void add(CreateCellPhoneRequest createCellPhoneRequest) throws Exception {
		CellPhone cellPhone = new CellPhone();
		Brand brand = brandRepository.findById(createCellPhoneRequest.getBrandId()).get();
		cellPhone.setBrand(brand);
		cellPhone.setName(createCellPhoneRequest.getName());
		cellPhone.setUnitPrice(createCellPhoneRequest.getUnitPrice());
		cellPhone.setDiscountRate(createCellPhoneRequest.getDiscountRate());
		cellPhone.setUnitInStock(createCellPhoneRequest.getUnitInStock());
		cellPhone.setBatterySize(createCellPhoneRequest.getBatterySize());
		cellPhone.setMemorySize(createCellPhoneRequest.getMemorySize());
		cellPhone.setRamSize(createCellPhoneRequest.getRamSize());
		cellPhone.setScreenSize(createCellPhoneRequest.getScreenSize());
		cellPhone.setColour(createCellPhoneRequest.getColour());
		productRepository.save(cellPhone);
		cellPhoneRepository.save(cellPhone);

	}

	@Override
	public void delete(DeleteCellPhoneRequest deleteCellPhoneRequest) {
		CellPhone cellPhone = cellPhoneRepository.findById(deleteCellPhoneRequest.getId()).get();
		cellPhoneRepository.delete(cellPhone);
		productRepository.delete(cellPhone);

	}

	@Override
	public void update(UpdateCellPhoneRequest updateCellPhoneRequest) {
		CellPhone cellPhone = cellPhoneRepository.findById(updateCellPhoneRequest.getId()).get();
		Brand brand = brandRepository.findById(updateCellPhoneRequest.getBrandId()).get();
		cellPhone.setBrand(brand);
		cellPhone.setName(updateCellPhoneRequest.getName());
		cellPhone.setUnitPrice(updateCellPhoneRequest.getUnitPrice());
		cellPhone.setDiscountRate(updateCellPhoneRequest.getDiscountRate());
		cellPhone.setUnitInStock(updateCellPhoneRequest.getUnitInStock());
		cellPhone.setBatterySize(updateCellPhoneRequest.getBatterySize());
		cellPhone.setMemorySize(updateCellPhoneRequest.getMemorySize());
		cellPhone.setRamSize(updateCellPhoneRequest.getRamSize());
		cellPhone.setScreenSize(updateCellPhoneRequest.getScreenSize());
		cellPhone.setColour(updateCellPhoneRequest.getColour());
		cellPhoneRepository.save(cellPhone);
		productRepository.save(cellPhone);
		brandRepository.save(brand);

	}

	@Override
	public List<GetAllCellPhoneResponse> getAll() {
		List<CellPhone> cellPhones = cellPhoneRepository.findAll();
		List<GetAllCellPhoneResponse> cellPhoneResponses = new ArrayList<GetAllCellPhoneResponse>();
		for (CellPhone cellPhone : cellPhones) {
			GetAllCellPhoneResponse responseItem = new GetAllCellPhoneResponse();
			responseItem.setId(cellPhone.getId());
			responseItem.setName(cellPhone.getName());
			responseItem.setUnitPrice(cellPhone.getUnitPrice());
			responseItem.setDiscountRate(cellPhone.getDiscountRate());
			responseItem.setUnitInStock(cellPhone.getUnitInStock());
			responseItem.setBrandId(cellPhone.getBrand().getId());
			responseItem.setBrandName(cellPhone.getBrand().getName());
			responseItem.setBatterySize(cellPhone.getBatterySize());
			responseItem.setMemorySize(cellPhone.getMemorySize());
			responseItem.setRamSize(cellPhone.getRamSize());
			responseItem.setScreenSize(cellPhone.getScreenSize());
			responseItem.setColour(cellPhone.getColour());

			cellPhoneResponses.add(responseItem);
		}

		return cellPhoneResponses;
	}

	@Override
	public GetByIdCellPhoneResponse getById(int id) {
		Optional<CellPhone> cellPhone = cellPhoneRepository.findById(id);
		GetByIdCellPhoneResponse responseItem = new GetByIdCellPhoneResponse();
		responseItem.setName(cellPhone.get().getName());
		return responseItem;
	}

}
