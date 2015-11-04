package org.jnit.inheritance.vehicle;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "fourWheeler")
public class FourWheeler extends Vehicle {

	private String steeringFourWheeler;

	public String getSteeringFourWheeler() {
		return steeringFourWheeler;
	}

	public void setSteeringFourWheeler(String steeringFourWheeler) {
		this.steeringFourWheeler = steeringFourWheeler;
	}

}
