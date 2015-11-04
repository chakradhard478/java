package org.jnit.inheritance.vehicle;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "twoWheeler")
public class TwoWheeler extends Vehicle {

	private String steeringTwoWheeler;

	public String getSteeringTwoWheeler() {
		return steeringTwoWheeler;
	}

	public void setSteeringTwoWheeler(String steeringTwoWheeler) {
		this.steeringTwoWheeler = steeringTwoWheeler;
	}

}
