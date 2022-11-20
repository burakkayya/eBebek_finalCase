package ebebekJava.patikaStore.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ebebekJava.patikaStore.entities.concretes.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

}
