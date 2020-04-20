package com.amazon.tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amazon.keywords.Constants;
import com.amazon.keywords.Keywords;

import FileUtility.Custstom_Listener;
import FileUtility.PropertiesFile;

@Listeners(Custstom_Listener.class)
public class AddToCartPageTests  extends Base{

	Logger log = Logger.getLogger("AddToCartPageTests");
	
	@Test(priority = 1)
	public void verifySearchItem() throws InterruptedException, IOException {
		log.info("*** Verify Search Item ***");
		HomePageTests hp = new HomePageTests();
		log.info("Create object of HomePageTests class");
		hp.verifySearchBox();
		log.info("Call SearchBox method of class HomePageTests");
		log.info("Items successfully search on searchbox");
	}
	
	@Test(priority = 2)
	public void verifyAddToCart() throws InterruptedException, IOException {
		log.info("***  Verify AddToCart ***");
		Keywords.moveToElement(PropertiesFile.getLocator("moveEle1")[0], PropertiesFile.getLocator("moveEle1")[1]);
		Thread.sleep(2000);
		Keywords.switchOnWindow(PropertiesFile.getLocator("img")[0], PropertiesFile.getLocator("img")[1]);
		String s=Constants.driver.getTitle();
		System.out.println(s);
		Keywords.moveToElement(PropertiesFile.getLocator("movEle2")[0], PropertiesFile.getLocator("movEle2")[1]);
		Keywords.clickOnElement(PropertiesFile.getLocator("clk")[0], PropertiesFile.getLocator("clk")[1]); 
		log.info("Click on Add To Cart");
		Keywords.captureFullPageScreenShot();
		log.info("After adding element capture screenshot");
		
	}

}
