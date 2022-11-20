package ebebekJava.patikaStore.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ebebekJava.patikaStore.entities.concretes.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer>{

}
