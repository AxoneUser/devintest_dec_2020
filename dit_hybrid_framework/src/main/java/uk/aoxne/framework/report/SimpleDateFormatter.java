package uk.aoxne.framework.report;

import org.testng.annotations.Test;

import java.util.Date;

/**
 * @author Karthik.Gandhinathan
 */
public class SimpleDateFormatter {

    @Test
    public void sampleDate(){
        Date d = new Date();
        //System.out.println(d);
        System.out.println(d.toString().replace(" ", "_").replace(":", "_"));
    }
}
