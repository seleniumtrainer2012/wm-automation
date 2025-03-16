package com.ubs.wmautomation.testcases;

import org.testng.annotations.AfterSuite;

import com.aventstack.extentreports.ExtentReports;
import com.ubs.wmautomation.libs.Web;
import com.ubs.wmautomation.utility.Reporting;

public class BaseTest {


	@AfterSuite
	public void quitBrowser() {

		Web.closeBrowser();
	}	

}
