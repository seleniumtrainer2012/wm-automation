package com.ubs.wmautomation.testcases;

import org.testng.annotations.AfterSuite;

import com.aventstack.extentreports.ExtentReports;
import com.ubs.wmautomation.libs.Web;
import com.ubs.wmautomation.util.Reporting;

public class BaseTest {


	@AfterSuite
	public void quitBrowser() {

		Web.closeBrowser();
	}	

}
