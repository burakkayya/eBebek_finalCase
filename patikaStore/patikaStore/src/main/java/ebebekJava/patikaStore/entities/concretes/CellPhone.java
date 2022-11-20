package ebebekJava.patikaStore.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="cellphone")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CellPhone extends Product{

	@Column(name="memorySize")
	String memorySize;
	@Column(name="screenSize")
	String screenSize;
	@Column(name="batterySize")
	String batterySize;
	@Column(name="ramSize")
	String ramSize;
	@Column(name="colour")
	String colour;
	
}
