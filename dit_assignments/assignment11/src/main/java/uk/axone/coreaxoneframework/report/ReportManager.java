package uk.axone.coreaxoneframework.report;

import java.io.File;
import java.util.Date;

import org.apache.commons.lang3.SystemUtils;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ReportManager {

	private static ExtentReports extent;

	public synchronized static ExtentReports getInstance() {
		// if already report exists don't create a new instance
		if (extent == null) {
			Date d = new Date();
			String filename = d.toString().replace(" ", "_").replace(":", "_") + ".html";
			String reportPath = SystemUtils.getUserDir() + "/target/" + filename;

			// 1. Create new instance of extent report
			extent = new ExtentReports(reportPath, true, DisplayOrder.OLDEST_FIRST);
			// 2.load the external config file
			extent.loadConfig(new File(SystemUtils.getUserDir() + "/src/main/resources/extent-config.xml"));

		}

		return extent;
	}

}
