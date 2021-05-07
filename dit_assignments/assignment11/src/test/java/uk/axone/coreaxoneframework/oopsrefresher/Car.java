package uk.axone.coreaxoneframework.oopsrefresher;

//Car is-a Vehicle
//IS-A Relationship
public class Car extends Vehicle {
	public String yearOfMake;

	// Aggregation
	// HAS-A relationship
	public Engine myEngine;

	public void satNav() {
		System.out.println("I'm inside Sat Nav method -- Car");
	}

	public static void main(String[] args) {
		Car audiCar = new Car();
		audiCar.accelerate();
		audiCar.satNav();
		audiCar.myEngine.bhp = 1000;
	}

}
