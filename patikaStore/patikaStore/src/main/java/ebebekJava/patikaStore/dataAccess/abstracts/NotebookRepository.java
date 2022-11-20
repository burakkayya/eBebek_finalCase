package ebebekJava.patikaStore.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ebebekJava.patikaStore.entities.concretes.Notebook;

@Repository
public interface NotebookRepository extends JpaRepository<Notebook,Integer>{

}
