package uk.axone.screenshots;

import org.testng.annotations.Test;

/**
 * @author Karthik.Gandhinathan
 */
public class SimpleTypeCasting {

    @Test
    public void simpleTypeCast(){
        double salary = 99999.9999;
        int mySimpleSalary;

        System.out.println("Before Casting my salary: " + salary);

        mySimpleSalary = (int) salary;
        System.out.println("After casting, my salary: " + mySimpleSalary);


    }
}
