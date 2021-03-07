package uk.axone.testngadvanced;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author Karthik.Gandhinathan
 */
public class TestHowParameterizationWorks {

    @Parameters({"username", "password", "city", "gender"})
    @Test
    public void loginTest(String name, String pass, String aCity, String aGender){
        System.out.println("My username is: "+name+
                            " and password is: "+pass+
                               " and I live in : "+aCity+
                               " and gender is: : "+aGender
        );
    }


}
