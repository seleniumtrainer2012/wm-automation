package com.ubs.wmautomation.utility;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporting {

	private static ExtentReports extent=null;
	public static ExtentReports getInstance(){		
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("Reports/Spark.html");
		extent.attachReporter(spark);
		return extent;		
		/*
		if(report==null){
			Date d=new Date();
			String TimeStamp=d.toString().replace(" ", "_").replace(":", "_");
			report=new ExtentReports(System.getProperty("user.dir")+"\\Reports\\r_"+TimeStamp+".html");
			return report;
		}else{
			return report;
		}*/
	}
}
