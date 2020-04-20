package com.amazon.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.amazon.keywords.Constants;
import com.amazon.keywords.Keywords;

public class Base extends Keywords {
	
	 Logger log = Logger.getLogger("Base");
	 
	@BeforeTest
	public void launchBrowser() {
		PropertyConfigurator.configure("log4j.properties");
		log.info("************ Launching Chrome Browser ************");
		Keywords.openBrowser("Chrome");
		log.info("*********** Opening application URL ************");
		Keywords.launchUrl("http://www.amazon.in/");
		Keywords.maximizeBrowser();
		Constants.driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	}
	
	
	@AfterTest
	public void quitBrowser() {
		log.info("************* close Browser ***********");
		Keywords.closeBrowser();	
	}
	
	
	
	

}
