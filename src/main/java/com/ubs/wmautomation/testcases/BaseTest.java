package com.ubs.wmautomation.testcases;

import org.testng.annotations.AfterSuite;

import com.aventstack.extentreports.ExtentReports;
import com.ubs.wmautomation.libs.Web;
import com.ubs.wmautomation.utility.Reporting;

public class BaseTest {
	ExtentReports extent=Reporting.getInstance();
	

	@AfterSuite
	public void quitBrowser() {
		Web.closeBrowser();
		extent.flush();
	}	

}
