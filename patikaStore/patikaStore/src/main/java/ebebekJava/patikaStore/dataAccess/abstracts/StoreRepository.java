package ebebekJava.patikaStore.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ebebekJava.patikaStore.entities.concretes.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store,Integer>{

}
