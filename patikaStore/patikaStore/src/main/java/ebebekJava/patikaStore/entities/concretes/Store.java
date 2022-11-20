package ebebekJava.patikaStore.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="store")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	@Column(name="name")
	String name;
	@JsonIgnore
	@OneToMany(mappedBy = "store")
	//@JoinColumn(name = "brand_id")
	List<Brand> brands;
	
}
