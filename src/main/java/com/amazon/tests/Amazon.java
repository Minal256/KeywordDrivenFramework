package com.amazon.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.keywords.Constants;
import com.amazon.keywords.Keywords;

public class Amazon {
	@BeforeTest
	public void launchBrowser() {
		Keywords.openBrowser("Chrome");
		Keywords.launchUrl("http://www.amazon.in/");
		Keywords.maximizeBrowser();
	}
	
	@Test(priority = 1)
	public void verifyPageTitleTest() {
		String actual="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String expected=Keywords.pageTitle();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 2)
	public void verifyAmazonLogo() {
		boolean b=Keywords.logoDisplay("CSS", "div#nav-logo");
		Assert.assertTrue(b, "Amazon Logo is not dispalyed.");
	}
	
	@Test(priority = 3)
	private void verifyAmazonLogoColor() {
		String expected="#111111";
		String actual=Keywords.logoColor("CSS", "div#nav-logo");
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 4, enabled = true)
	public void verifyAmazonLogoClickable() throws InterruptedException {
		String expected="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Keywords.clickOnElement("CSS", "div#nav-logo");
		System.out.println("Amazon.in logo is clickable");
	//	Keywords.AmazonHomePage();
		String actual=Constants.driver.getTitle();
		Assert.assertEquals(actual, expected);
		Thread.sleep(3000);
	}
	
	@Test(priority = 5)
	public void verifyTryPrimeLabel() {
		boolean b1=Keywords.elementLabelDisplay("CSS", "a[href=\"/prime?ref_=nav_logo_prime_join\"]");
		Assert.assertTrue(b1, "TryPrime Label is not displayed.");
	}
	
	@Test(priority = 6)
	public void verifyTryPrimeLabelColor() {
		String expected="#48a3c6";
		String actual=Keywords.logoColor("CSS", "a[href=\"/prime?ref_=nav_logo_prime_join\"]");
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 7)
	public void verifyTryPrimeClickable() throws InterruptedException {
		String actual="https://www.amazon.in/amazonprime?_encoding=UTF8&ref_=nav_logo_prime_join";
		Keywords.clickOnElement("CSS", "a[href=\"/prime?ref_=nav_logo_prime_join\"]");
		String expected=Constants.driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 8)
	public void verifyTryPrimePagetitle() {
		String title=Keywords.pageTitle();
		Assert.assertEquals(title, "Amazon.in: Amazon Prime");
	}
	
	@Test(priority = 9)
	public void verifyLoginToPrimeButton() {
		Keywords.buttonDisplay("CSS", "span#a-autoid-0.a-button.a-button-primary");
		System.out.println("Login To Prime button is displayed sucessfully on Try prime page");
	}
	
	@Test(priority = 10)
	public void verifyLoginToPrimeButtonColor() throws InterruptedException {
		String expected="#f0c14b";
		String actual=Keywords.buttonColor("CSS", "span#a-autoid-0.a-button.a-button-primary");
		Assert.assertEquals(actual, expected);
		Thread.sleep(3000);		
	}
	
	@Test(priority = 11)
	public void verifyLoginToPrimeButtonTextColor() throws InterruptedException {
		String expected="#111111";
		String actual=Keywords.buttonTextColor("CSS", "a#a-autoid-0-announce");
		Assert.assertEquals(actual, expected);
		Thread.sleep(3000);	
	}
	
//	@Test(priority = 12)
//	public void verifyLoginToprimeButtonClickableAnd_BackToAmazonHomePage() throws InterruptedException {
//		String expected="Amazon Sign In";
//		Keywords.clickOnElement("CSS", "span#a-autoid-0.a-button.a-button-primary");
//		String actual=Constants.driver.getTitle();
//		System.out.println(expected);
//		Assert.assertEquals(actual, expected);
//		Thread.sleep(3000);
//		Constants.driver.navigate().back();
//		verifyAmazonLogoClickable();
//		System.out.println(Constants.driver.getTitle());
//	}
	
//	@Test(priority = 13)
//	public void verifyIconNavBarLabel() {
//		String expected="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
//		Keywords.elementLabelDisplay("CSS", "i.hm-icon.nav-sprite");
//		String actual=Constants.driver.getTitle();
//		Assert.assertEquals(actual, expected);
//	} 
//	
//	@Test(priority = 14)
//	public void verifyIconNavbarClickable() {
//		String expected="https://www.amazon.in/ref=nav_logo";
//		Keywords.clickOnElement("CSS", "i.hm-icon.nav-sprite");
//		String actual=Constants.driver.getCurrentUrl();
//		Assert.assertEquals(actual, expected);
//	}
	
//	@Test(priority = 15)
//	public void verifyIconNavbarItems() {
//		boolean isequal=Keywords.iconNavBarItems("CSS", "#hmenu-content>ul.hmenu.hmenu-visible>li").containsAll(Arrays.asList(Constants.expectedSubNavitems));
//		Assert.assertTrue(isequal, "Items is in iconNavbar is not varified");
//	}
//	
}




