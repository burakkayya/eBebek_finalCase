package ebebekJava.patikaStore.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import ebebekJava.patikaStore.business.requests.cellphone.CreateCellPhoneRequest;
import ebebekJava.patikaStore.business.requests.cellphone.DeleteCellPhoneRequest;
import ebebekJava.patikaStore.business.requests.cellphone.UpdateCellPhoneRequest;
import ebebekJava.patikaStore.business.responses.cellphone.GetAllCellPhoneResponse;
import ebebekJava.patikaStore.business.responses.cellphone.GetByIdCellPhoneResponse;

@Service
public interface CellPhoneService {

	void add(CreateCellPhoneRequest createCellPhoneRequest) throws Exception;

	void delete(DeleteCellPhoneRequest deleteCellPhoneRequest);

	void update(UpdateCellPhoneRequest updateCellPhoneRequest);

	List<GetAllCellPhoneResponse> getAll();

	GetByIdCellPhoneResponse getById(int id);
}
