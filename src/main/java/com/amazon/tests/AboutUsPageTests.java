package com.amazon.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.keywords.Constants;
import com.amazon.keywords.Keywords;
import com.amazon.keywords.ReadNavItemsList;

import FileUtility.PropertiesFile;


public class AboutUsPageTests extends Base { //base class madhe keywords class chy methods aslymule ty ya class la pn accessiable ashnar
	
	Logger log = Logger.getLogger("AboutUsPageTests");
	
	@Test(priority = 1, enabled = true)
	public void verifyAboutUsLabel() {
		log.info("*** Verify AboutUs label ***");
		Keywords.pageScrollDown();
		boolean b3=Keywords.isElementDisplay(PropertiesFile.getLocator("aboutUs")[0], PropertiesFile.getLocator("aboutUs")[1]);
		Assert.assertTrue(b3 ,"About Us label is not display");
		log.info("AboutUs label successfully display on Amazon Home page");
	}
	
	@Test(priority = 2, enabled = true)
	public void verifyAboutUsClickable() {
		log.info("*** Verify AboutUsclickable ***");
		Keywords.pageScrollDown();
		log.info("Home page scroll down");
		Keywords.clickOnElement(PropertiesFile.getLocator("clkAboutUs")[0], PropertiesFile.getLocator("clkAboutUs")[1]);
		log.info("Click AboutUs label");
		String title=Constants.driver.getTitle();
		Assert.assertEquals(title, "Amazon India transforms small business in India");
		log.info("After clicked AboutUs label open AboutUs page");
	}
	
	@Test(priority = 3, enabled = true)
	public void verifyAboutUsPageTitle() {
		log.info("*** Verify AboutUs page title");
		String title = Keywords.getPageTitle();
		Assert.assertEquals(title ,"Amazon India transforms small business in India");
		log.info("AboutUs page title displayed successfully displayed");
	}
	
	@Test(priority = 4, enabled = true)
	public void verifyAmazonLogoImage() {
		log.info("*** Verify AmzonLogo image ***");
		boolean logo=Keywords.isLogoDisplay(PropertiesFile.getLocator("amazonLogoImg")[0], PropertiesFile.getLocator("amazonLogoImg")[1]);
		Assert.assertTrue(logo, "Amazone logo image is not display");
		log.info("Amazon logo displayed successfully on AboutUs page");
	}
	
	@Test(priority = 5, enabled = true)
	public void verifyAmazonLogoImageClickable() {
		log.info("*** Verify Amazon logo image clickable ***");
		String expected = "https://www.aboutamazon.in/";
		Keywords.clickOnElement(PropertiesFile.getLocator("clkAmazonLogo")[0], PropertiesFile.getLocator("clkAmazonLogo")[1]);
		log.info("Click Amazonlogo");
		String actual=Constants.driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
		log.info("Logo successfully clicked and stays on same page");
	}
	
	@Test(priority = 6)
	public void verifyIconNavBar() {
		log.info("*** Verify IconNavbar ***");
		boolean b = Keywords.isElementDisplay(PropertiesFile.getLocator("iconNavBar2")[0], PropertiesFile.getLocator("iconNavBar2")[1]);
		Assert.assertTrue(b, "IconNavbar  is not displayed. ");
		log.info("Icon NavBar displayed successfully on AboutUs page");
	}
	
	@Test(priority = 7)
	public void verifyIconNavBarClickable() throws InterruptedException {
		log.info("*** Verify Icon Navbar clickable ***");
		Keywords.clickOnElement(PropertiesFile.getLocator("clkIconNavBar2")[0], PropertiesFile.getLocator("clkIconNavBar2")[1]);
		log.info("Click Icon Navbar");
		String expected = "Amazon India transforms small business in India";
		String actual = Constants.driver.getTitle();
		Assert.assertEquals(actual, expected);
		Thread.sleep(5000);
		
	}
	
	@Test(priority = 8, dataProvider = "readCSV" , dataProviderClass = ReadNavItemsList.class)
	public void verifyNavItemsList(String val) {
		log.info("*** Verify Nav items List ***");
		System.out.println(val);
//		String expectedList=val;
//		JavascriptExecutor js = (JavascriptExecutor)Constants.driver;
//		String actualList=(String) js.executeScript("document.getElementsByClassName('NavigationItem mood-color')[3]");
//		Assert.assertEquals(actualList, expectedList);
		log.info("Nav items list displayed successfully");
	} 
	
	@Test(priority = 9)
	public void verifyCloseIconNavBar() throws InterruptedException {
		log.info("*** Verify Close Icon navbar ***");
		Thread.sleep(3000);
		Keywords.clickOnElement(PropertiesFile.getLocator("closeIconNavBar2")[0], PropertiesFile.getLocator("closeIconNavBar2")[1]);
		log.info("Click on close");
		log.info("Icon navbar close successfully");
	}
}
