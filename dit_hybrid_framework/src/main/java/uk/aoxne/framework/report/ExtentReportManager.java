package uk.aoxne.framework.report;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import org.apache.commons.lang3.SystemUtils;

import java.io.File;
import java.util.Date;

/**
 * @author Karthik.Gandhinathan
 */
public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        // if already an extent report exists then don't create a new instance.
        if (extent == null) {
            Date d = new Date();
            String fileName = d.toString().replace(" ", "_").replace(":", "_") + ".html";

            //1. to create a new extent report instance.
            extent = new ExtentReports(SystemUtils.getUserDir() + "/target/reports/" + fileName, true, DisplayOrder.NEWEST_FIRST);

            //2. to load the config file
            extent.loadConfig(new File(SystemUtils.getUserDir() + "/src/main/resources/config.xml"));
        }

        return extent;
    }


}
