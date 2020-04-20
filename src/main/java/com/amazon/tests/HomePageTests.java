package com.amazon.tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.keywords.Constants;
import com.amazon.keywords.Keywords;

import FileUtility.PropertiesFile;

public class HomePageTests extends Base {
	
	 Logger log = Logger.getLogger("HomePageTests");
	 
	@Test(priority = 1)
	public void verifyAmazonHomePageTitle() throws InterruptedException {
		log.info("*** Verify Amazon Home page title ***");
		String title = Keywords.getPageTitle();
		log.info("Amazon home page title------>" + title);
		Assert.assertEquals(title,"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		log.info("Amazon Home page title displayed successfully");
	}
	
	@Test(priority = 2)
	public void verifyAmazonLogo() {
		log.info("*** Verify Amazon Logo ***");
		boolean b = Keywords.isLogoDisplay(PropertiesFile.getLocator("amazonLogo")[0],PropertiesFile.getLocator("amazonLogo")[1]);
		Assert.assertTrue(b, "Amazon Logo is not dispalyed.");
		log.info("Amazon logo displayed on amazon home page");
	}
	
	@Test(priority = 3)
	public void verifyAmazonLogoClickable() throws InterruptedException {
		log.info("*** Verify amazon logo clickable ***");
		String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Keywords.clickOnElement(PropertiesFile.getLocator("logoclk")[0], PropertiesFile.getLocator("logoclk")[1]);
		log.info("Click amazon logo");
		String actual = Constants.driver.getTitle();
		Assert.assertEquals(actual, expected);
		Thread.sleep(3000);
		log.info("Amazon logo clicked successfully and redirected to amazon home page");
	}
	
	@Test(priority = 4)
	public void verifyTryPrimeLabel() {
		log.info("*** Verify Try Prime label ***");
		boolean b1 = Keywords.isElementDisplay(PropertiesFile.getLocator("TryPrimeLabel")[0],PropertiesFile.getLocator("TryPrimeLabel")[1]);
		Assert.assertTrue(b1, "TryPrime Label is not displayed.");
		log.info("Try prime label successfully display on amazon home page");
	}

	@Test(priority = 5)
	public void verifyTryPrimeLabelColor() {
		log.info("*** Verify Try Prime label color ***");
		String expected = "#48a3c6";
		String actual = Keywords.getElementLabelColor(PropertiesFile.getLocator("labelColor")[0],PropertiesFile.getLocator("labelColor")[1]);
	//	System.out.println(actual);
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 6)
	public void verifyTryPrimeClickable() throws InterruptedException {
		log.info("*** Verify Try Prime label clickable ***");
		String expected = "https://www.amazon.in/amazonprime?_encoding=UTF8&ref_=nav_logo_prime_join";
		Keywords.clickOnElement(PropertiesFile.getLocator("clkTryPrime")[0],PropertiesFile.getLocator("clkTryPrime")[1]);
		log.info("Click Try Prme");
		String actual = Constants.driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
		log.info("Navigate back to TryPrime");
		Constants.driver.navigate().back();
		Thread.sleep(3000);
		log.info("Try Prime label clicked and home to home page");
	}
	
	@Test(priority = 7)
	public void verifyIconNavBar() {
		log.info("*** Verify Icon Navbar ***");
		String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Keywords.isElementDisplay(PropertiesFile.getLocator("iconNavBar1")[0],PropertiesFile.getLocator("iconNavBar1")[1]);
		String actual = Constants.driver.getTitle();
		Assert.assertEquals(actual, expected);
		log.info("Icon Nav bar successfully display on amazon home page");
	}
	
	@Test(priority = 8)
	public void verifyIconNavbarClickable() {
		log.info("*** Verify ICon Navbar ***");
		String expected = "https://www.amazon.in/ref=nav_logo";
		Keywords.clickOnElement(PropertiesFile.getLocator("clkIconNavBar1")[0], PropertiesFile.getLocator("clkIconNavBar1")[1]);
		log.info("Click Icon Navbar");
		String actual = Constants.driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
		log.info("Icon navbar clicked and open list");
	}

	@Test(priority = 9)
	public void verifyCloseIconNavBar() throws InterruptedException {
		log.info("*** Verify CloseIcon Navbar ***");
		Thread.sleep(3000);
		Keywords.clickOnElement(PropertiesFile.getLocator("closeIconNavBar1")[0],PropertiesFile.getLocator("closeIconNavBar1")[1]);
		log.info("Click on close");
		log.info("Icon NavBar close successfully");
	}
	
	@Test(priority = 10)
	public void verifySearchBox() throws InterruptedException, IOException {
		log.info("*** Verify Search Box ***");
		String expectedUrl="Amazon.in : chocolates";
		Keywords.clickOnElement(PropertiesFile.getLocator("searchTextBox")[0], PropertiesFile.getLocator("searchTextBox")[1]);
		log.info("Click on search box");
		Keywords.enterText(PropertiesFile.getLocator("searchText")[0], PropertiesFile.getLocator("searchText")[1], "chocolates");
		log.info("Entering text into search box");
		Thread.sleep(3000);
		Keywords.clickOnElement(PropertiesFile.getLocator("search-submit")[0], PropertiesFile.getLocator("search-submit")[1]);
		log.info("Click on search-submit");
		Keywords.captureFullPageScreenShot();
		log.info("After clicked search-submitt icon capture fullpage screenshot");
		String actualUrl=Constants.driver.getTitle();
		Assert.assertEquals(actualUrl,expectedUrl);
		log.info("Search box successfully search item");
	}
}
