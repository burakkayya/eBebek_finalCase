package ebebekJava.patikaStore.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ebebekJava.patikaStore.entities.concretes.CellPhone;

@Repository
public interface CellPhoneRepository extends JpaRepository<CellPhone,Integer>{

}
