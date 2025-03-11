package com.ubs.wmautomation.testcases;

import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.util.Assert;
import com.ubs.wmautomation.libs.Utility;
import com.ubs.wmautomation.libs.Web;
import com.ubs.wmautomation.utility.Reporting;

public class Register_User {
	ExtentReports extent=Reporting.getInstance();
	/*
	 * 
	 * 
	 */
	@Test(groups = {"Reg"})
	public void Add_New_User_Testcase() throws Exception {		
		ExtentTest test=extent.createTest("Add_New_User_Testcase");
		
		System.out.println("Add_New_User_Testcase");
		//load config files
		Properties active_env=Utility.loadConfig();

		//code
		Web.launchBrowser(active_env.getProperty("brower.name"));
		Web.navigate(active_env.getProperty("application.url"));
		test.log(Status.INFO, "launching "+active_env.getProperty("application.url")+ "application");
			
		Web.getTitle();
		String title=Web.getTitle();
		test.log(Status.INFO, "appliction title is  "+title);
		Web.captureScreeshot();
		System.out.println("Title of website is -"+title);
		//Web.closeBrowser();
		org.testng.Assert.assertEquals(title,"DEMOQA");
		test.log(Status.PASS, "Varify website title: actual -"+title+", expected=DEMOQA");
		
		
		

	}


	@Test(groups = {"Reg","Sanity"})
	public void Update_Existing_User_Testcase() throws Exception {
		ExtentTest test=extent.createTest("Update_Existing_User_Testcase");
		
		System.out.println("Update_Existing_User_Testcase");
		//load config files
		Properties active_env=Utility.loadConfig();

		//code
		Web.launchBrowser(active_env.getProperty("brower.name"));
		test.log(Status.INFO, "browser name "+active_env.getProperty("brower.name")+ " launched");
		
		Web.navigate(active_env.getProperty("application.url"));
		test.log(Status.INFO, "browser name "+active_env.getProperty("brower.name")+ " launched");
		
		String title=Web.getTitle();
		Web.captureScreeshot();
		//test.addScreenCaptureFromPath("")
		
		System.out.println("Title of website is -"+title);
		

	}

	@AfterSuite
	public void quitBrowser() {
		Web.closeBrowser();
		extent.flush();
	}	



}
