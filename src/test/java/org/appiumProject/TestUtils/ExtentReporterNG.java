package org.appiumProject.TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG 
{
	static ExtentReports extent;
	
	public static ExtentReports getExtentReporterObject()
	{
		String path=System.getProperty("user.dir")+"//report//index.html";
		ExtentSparkReporter report=new ExtentSparkReporter(path);
		report.config().setReportName("Appium Automation Result");
		report.config().setDocumentTitle("Test Result");
		
		extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Surya Krishnan");
		return extent;
	}

}
