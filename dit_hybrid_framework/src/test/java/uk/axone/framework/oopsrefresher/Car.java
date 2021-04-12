package uk.axone.framework.oopsrefresher;

/**
 * @author Karthik.Gandhinathan
 */

//Inheritance
//CAR IS-A Vehicle
public class Car extends Vehicle{

    public String yearOfMake;


    //Aggregation - unrelated classes
    //HAS A Relationship
    //CAR HAS-A Engine
    public Engine myEngine;


    public void satNavigation(){
        System.out.println("Inside Car's Sat Nav Method");
    }

    public static void main(String[] args) {
        Car bentley = new Car();
        bentley.accelerate();
        bentley.satNavigation();
        //bentley.myEngine.engineSize = 1000;
    }


}
