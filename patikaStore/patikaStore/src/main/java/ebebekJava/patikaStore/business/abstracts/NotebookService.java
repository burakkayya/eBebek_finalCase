package ebebekJava.patikaStore.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import ebebekJava.patikaStore.business.requests.notebook.CreateNotebookRequest;
import ebebekJava.patikaStore.business.requests.notebook.DeleteNotebookRequest;
import ebebekJava.patikaStore.business.requests.notebook.UpdateNotebookRequest;
import ebebekJava.patikaStore.business.responses.notebook.GetAllNoteBookResponse;
import ebebekJava.patikaStore.business.responses.notebook.GetByIdNotebookResponse;

@Service
public interface NotebookService{

	void add(CreateNotebookRequest createNotebookRequest) throws Exception;

	void delete(DeleteNotebookRequest deleteNotebookRequest);

	void update(UpdateNotebookRequest updateNotebookRequest);

	List<GetAllNoteBookResponse> getAll();

	GetByIdNotebookResponse getById(int id);
}
