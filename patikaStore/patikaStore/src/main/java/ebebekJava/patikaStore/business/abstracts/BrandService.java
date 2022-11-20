package ebebekJava.patikaStore.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import ebebekJava.patikaStore.business.requests.brand.CreateBrandRequest;
import ebebekJava.patikaStore.business.requests.brand.DeleteBrandRequest;
import ebebekJava.patikaStore.business.requests.brand.UpdateBrandRequest;
import ebebekJava.patikaStore.business.responses.brand.GetAllBrandResponse;
import ebebekJava.patikaStore.business.responses.brand.GetByIdBrandResponse;

@Service
public interface BrandService {

	void add(CreateBrandRequest createBrandRequest) throws Exception;

	void delete(DeleteBrandRequest deleteBrandRequest);

	void update(UpdateBrandRequest updateBrandRequest);

	List<GetAllBrandResponse> getAll();

	GetByIdBrandResponse getById(int id);
}
