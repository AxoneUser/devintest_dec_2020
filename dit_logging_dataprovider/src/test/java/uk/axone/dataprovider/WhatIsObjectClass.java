package uk.axone.dataprovider;

import org.testng.annotations.Test;

/**
 * @author Karthik.Gandhinathan
 */
public class WhatIsObjectClass {

    @Test
    public void testObject(){

        String firstName = "AxoneUK";
        int phone = 7898889;
        double salary = 999999.8989;
        boolean isNativeCitizen = true;


        Object[] obj = new Object[4];
        obj[0] = firstName;
        obj[1] = phone;
        obj[2] = salary;
        obj[3] = isNativeCitizen;

    }
}
