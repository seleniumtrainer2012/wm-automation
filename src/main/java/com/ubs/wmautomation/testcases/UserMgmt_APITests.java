package com.ubs.wmautomation.testcases;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ubs.wmautomation.libs.Web;

import com.ubs.wmautomation.utility.Reporting;

public class UserMgmt_APITests extends BaseTest {

	private ExtentReports extent=Reporting.getInstance();

	@Test
	public void addUser_Testcase() throws Exception {
		ExtentTest test=extent.createTest("addUser_Testcase");
		
		//code
		Web.launchBrowser("Chrome");
		test.log(Status.INFO, "running addUser_Testcase");	
		extent.flush();
	}

	@Test
	public void AddUser_GetCall_Testcase() {
		ExtentTest test=extent.createTest("AddUser_GetCall_Testcase");
		test.log(Status.INFO, "AddUser_GetCall_Testcase");	
		extent.flush();
	}
	@Test
	public void ModifyUser_UpdateCall_Testcase() {
		ExtentTest test=extent.createTest("ModifyUser_UpdateCall_Testcase");
		test.log(Status.INFO, "running addUser_Testcase");	
		extent.flush();
	}

}
