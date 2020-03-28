package com.amazon.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.keywords.Constants;
import com.amazon.keywords.Keywords;

public class SmokeTestCases {
	
	@Test(priority = 1, enabled = true)
	public void verifyAmazonSignIn() throws InterruptedException {
		Keywords.openBrowser("Chrome");
		Keywords.launchUrl("http://www.amazon.in/");
		Keywords.maximizeBrowser();
		String title=Constants.driver.getTitle();
	//	System.out.println(title);
		Keywords.moveToElement("CSS", "a#nav-link-accountList.nav-a.nav-a-2");
		Thread.sleep(3000);
		Keywords.clickOnElement("CSS", "span.nav-action-inner");
		
		//------- emailId enter ---------//
		Keywords.enterText("CSS", "input.a-input-text.a-span12.auth-autofocus.auth-required-field", "bhasmeminal@gmail.com");
		Keywords.clickOnElement("CSS", "input.a-button-input");
		Thread.sleep(3000);
		//------- password Enter -------//
		Keywords.enterText("CSS", "input.a-input-text.a-span12.auth-autofocus.auth-required-field", "minal");
		Keywords.clickOnElement("CSS", "input.a-button-input");
		Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		
	}
	@Test(priority = 2, enabled=true)
	public void verifySerachBox() throws InterruptedException {
		Keywords.openBrowser("Chrome");
		Keywords.launchUrl("http://www.amazon.in/");
		Keywords.maximizeBrowser();
		String expectedUrl="https://www.amazon.in/s?k=chocolates&ref=nb_sb_noss_1";
	//	Keywords.moveToElement("CSS", "input#twotabsearchtextbox");
		Keywords.clickOnElement("CSS", "input#twotabsearchtextbox");
	//  Keywords.enterText("CSS", "input#twotabsearchtextbox", "Home decor wallpaper");
		Keywords.enterText("CSS", "input#twotabsearchtextbox", "chocolates");
		Thread.sleep(3000);
		Keywords.clickOnElement("CSS", "div.nav-search-submit.nav-sprite");
		String actualUrl=Constants.driver.getCurrentUrl();
		Assert.assertEquals(actualUrl,expectedUrl);
	}
	
	@Test(priority = 3, enabled = false)
	public void verifyAmazonSignOut() throws InterruptedException {
		Keywords.openBrowser("Chrome");
		Keywords.launchUrl("http://www.amazon.in/");
		Keywords.maximizeBrowser();
		String title=Constants.driver.getTitle();
		System.out.println("signout:"+title);
		Keywords.moveToElement("CSS", "a#nav-link-accountList.nav-a.nav-a-2");
		Thread.sleep(3000);
		Keywords.moveToElement("CSS", "a#nav-item-signout.nav-link.nav-item");
		Keywords.clickOnElement("CSS", "a#nav-item-signout.nav-link.nav-item");
		Assert.assertEquals(title, "Amazon Sign In");

	}
	
	@Test(priority = 4, enabled= false)
	public void verifyAddToCart() throws InterruptedException {
		Keywords.openBrowser("Chrome");
		Keywords.launchUrl("http://www.amazon.in/");
		Keywords.maximizeBrowser();
//		Keywords.moveToElement("CSS", "img[src=\"https://m.media-amazon.com/images/I/71wFB1Gvy4L._AC_UL320_ML3_.jpg\"]");
//		Keywords.clickOnElement("CSS", "img[src=\"https://m.media-amazon.com/images/I/71wFB1Gvy4L._AC_UL320_ML3_.jpg\"]");
//	
		Keywords.moveToElement("CSS", "div.sg-col-20-of-24.sg-col-28-of-32.sg-col-16-of-20.sg-col.sg-col-32-of-36.sg-col-8-of-12.sg-col-12-of-16.sg-col-24-of-28");
	//	Keywords.clickOnElement("CSS", "img[src=\"https://m.media-amazon.com/images/I/51xmJNjfbfL._AC_UL320_ML3_.jpg\"]");
		Thread.sleep(2000);
		Keywords.windowHandleInNewTab("CSS", "img[src=\"https://m.media-amazon.com/images/I/51xmJNjfbfL._AC_UL320_ML3_.jpg\"]");
		String s=Constants.driver.getTitle();
		System.out.println(s);
		Keywords.moveToElement("CSS", "div#oneTimeBuyBox.a-box.a-accordion-active");
		Keywords.clickOnElement("CSS", "input#add-to-cart-button.a-button-input");
		
	}

}
