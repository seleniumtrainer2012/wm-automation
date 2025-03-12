package com.ubs.wmautomation.libs;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Web {
	static WebDriver driver=null;

	public static void closeBrowser() {
		driver.quit();
	}

    public static String captureScreeshot() throws IOException {
    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	// Now you can do whatever you need to do with it, for example copy somewhere
    	String screenshotPath=System.getProperty("user.dir")+"//Screenshots";
    	Date d=new Date();
    	String TimeStamp=d.toString().replace(" ", "_").replace(":", "_");
    	FileUtils.copyFile(scrFile, new File(screenshotPath+"//Screenshot_"+TimeStamp+"_.png"));
   
    	return screenshotPath+"//Screenshot_"+TimeStamp+"_.png";
    }
    
	public static void navigate(String URL) {
		driver.navigate().to(URL);		
	}


	public static String getTitle() {
		return driver.getTitle();	
	}

	public static WebDriver initChromeDriver() {
		if(driver==null) {

			ChromeOptions chromeOptions = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(chromeOptions);
			driver.manage().window().maximize();		
		}
		return driver;
	}
	public static WebDriver initEdgeDriver() {
		if(driver==null) {			
			EdgeOptions edgeOptions = new EdgeOptions();
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver(edgeOptions);
			driver.manage().window().maximize();		
		}
		return driver;
	}

	public static WebDriver launchBrowser(String name) throws Exception {
		WebDriver driver = null;
		Thread.sleep(2000);
		switch (name) {
		case "Chrome":			
			driver=initChromeDriver();
			break;
		case "IE":
			driver=initEdgeDriver();
			break;
		case "FF":
			driver=new ChromeDriver();
			break;
		default:
			throw new Exception("Invalid browser name provided!");
					}		
		return driver;

	}

}
