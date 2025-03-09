package com.ubs.wmautomation.testcases;

import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.ubs.wmautomation.libs.Utility;
import com.ubs.wmautomation.libs.Web;

public class Register_User {

	/*
	 * 
	 * 
	 */
	@Test(groups = {"Reg"})
	public void Add_New_User_Testcase() throws Exception {

		System.out.println("Add_New_User_Testcase");
		//load config files
		Properties active_env=Utility.loadConfig();

		//code
		Web.launchBrowser(active_env.getProperty("brower.name"));
		Web.navigate(active_env.getProperty("application.url"));
		Web.getTitle();
		String title=Web.getTitle();
		System.out.println("Title of website is -"+title);
		//Web.closeBrowser();

	}


	@Test(groups = {"Reg","Sanity"})
	public void Update_Existing_User_Testcase() throws Exception {

		System.out.println("Update_Existing_User_Testcase");
		//load config files
		Properties active_env=Utility.loadConfig();

		//code
		Web.launchBrowser(active_env.getProperty("brower.name"));
		Web.navigate(active_env.getProperty("application.url"));
		String title=Web.getTitle();
		System.out.println("Title of website is -"+title);


	}

	@AfterSuite
	public void quitBrowser() {
		Web.closeBrowser();
	}	



}
