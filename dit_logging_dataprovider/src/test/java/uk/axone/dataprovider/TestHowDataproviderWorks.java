package uk.axone.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Karthik.Gandhinathan
 */
public class TestHowDataproviderWorks {


    @Test(dataProvider = "LoginTestData")
    public void loginTest(String aUserName, String aPassword, double Salary, boolean aFlag){
        System.out.println("My username is : " + aUserName +
                               " My Password is: " + aPassword +
                               " and my salary is: " + Salary +
                               " am I a native citizen?: " + aFlag);
    }


    @DataProvider(name = "LoginTestData")
    public Object[][] supplyData(){

        Object[][] obj = new Object[2][4];

        obj[0][0] = "AxoneUsername1";
        obj[0][1] = "Password1";
        obj[0][2] = 9999990.9898;
        obj[0][3] = true;

        obj[1][0] = "US User1";
        obj[1][1] = "Password2";
        obj[1][2] = 77777777.9898;
        obj[1][3] = false;

        return obj;
    }

    @DataProvider(name = "BankDetails")
    public Object[][] supplyBankData(){

        Object[][] obj = new Object[2][4];

        obj[0][0] = "AxoneUsername1";
        obj[0][1] = "Password1";
        obj[0][2] = 9999990.9898;
        obj[0][3] = true;

        obj[1][0] = "US User1";
        obj[1][1] = "Password2";
        obj[1][2] = 77777777.9898;
        obj[1][3] = false;

        return obj;
    }


}
