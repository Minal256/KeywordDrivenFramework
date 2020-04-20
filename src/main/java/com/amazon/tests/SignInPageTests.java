package com.amazon.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amazon.keywords.Constants;
import com.amazon.keywords.Keywords;

import FileUtility.Custstom_Listener;
import FileUtility.PropertiesFile;

@Listeners(Custstom_Listener.class)
public class SignInPageTests extends Base {
	
	static Logger log = Logger.getLogger("SignInPageTests");
	
	@Test(priority = 1)
	public void verifyHelloSignInLabelClickable() {
		log.info("*** Vrify Hello Signin label clickable ***");
		Keywords.clickOnElement(PropertiesFile.getLocator("signin")[0], PropertiesFile.getLocator("signin")[1]);
		String expected="Amazon Sign In";
		String actual=Constants.driver.getTitle();
		Assert.assertEquals(actual, expected);
		log.info("Hello Signin label display successfully");	
	}
	
	@Test(priority = 2)
	public void verifyAmazonSigninPageTitle() {
		log.info("*** Verify amazon Signin page title ***");
		String title= Constants.driver.getTitle();
		Keywords.getPageTitle();
		Assert.assertEquals(title, "Amazon Sign In");
		log.info("Amazon Signin page title is ---->"+title);
	}

	@Test(priority = 3)
	public void verifyAmazonLogoOnSingInPage() {
		log.info("*** Verify amazon logo on signin page ***");
		boolean b=Keywords.isLogoDisplay(PropertiesFile.getLocator("amzLogoSignin")[0], PropertiesFile.getLocator("amzLogoSignin")[1]);
		Assert.assertTrue(b, "Logo is not display on signin page");
		log.info("Amazon logo successfully displayed on SignIn page");
		
	}
	
	@Test(priority = 4)
	public void verifyAmazonLogoOnSignInPageClickable() {
		log.info("*** Verify amazon logo is clickable ***");
		Keywords.clickOnElement(PropertiesFile.getLocator("clkAmzLogoSignIn")[0], PropertiesFile.getLocator("clkAmzLogoSignIn")[1]);
		log.info("click amazon logo");
		log.info("Amazon logo clicked successfully and redirected to amazon home page");
	}

	@Test(priority = 5)
	public static void verifyLoginLabel() {
		log.info("*** Verify Login label ***");
		Keywords.isElementDisplay(PropertiesFile.getLocator("loginLabel")[0], PropertiesFile.getLocator("loginLabel")[1] );
		log.info("Login label successfully displayed on SignIn page");
	}

	@Test(priority = 6)
	public void verifyEmailOrMobilePhoneNumberLabel() {
		log.info("*** Verify Email or Phone Number label ***");
		Boolean b1=Keywords.isElementDisplay(PropertiesFile.getLocator("emailPhoneLabel")[0], PropertiesFile.getLocator("emailPhoneLabel")[1]);
		log.info("Email or Mobile Phone Number label successfully display above Email or phone number field");
		Assert.assertTrue(b1);
	}

	@Test(priority = 7)
	public void verifyEmailOrPhoneField() {
		log.info("*** Verify Email or Phone number field ***");
		boolean b2=Keywords.isElementDisplay(PropertiesFile.getLocator("email")[0], PropertiesFile.getLocator("email")[1]);
		log.info("Email or Mobile Phone Number field successfully display below the Email or Mobile Phone Number label");
		Assert.assertTrue(b2);
	}

	@Test(priority = 8)
	public void verifyContinueButton() {
		log.info("*** Verify continue button ***");
		boolean b3=Keywords.isButtonDisplay(PropertiesFile.getLocator("continueBtn")[0], PropertiesFile.getLocator("continueBtn")[1]);
		Assert.assertTrue(b3);
		log.info("Continue button successfully display below Email or phone number field");
	}
	
	@Test(priority = 9)
	public void VerifyNeedHelpLink() {
		log.info("*** Verify need help link ***");
		boolean b4=Keywords.isElementDisplay(PropertiesFile.getLocator("needHelplink")[0], PropertiesFile.getLocator("needHelplink")[1]);
		Assert.assertTrue(b4);
		log.info("Need Help link successfully display on Sign in page");
	}
	
	@Test(priority = 10)
	public void verifyNeedHelpLinkClickableAndOpenDropDown() {
		log.info("*** Verify need help link dropdown ***");
		Keywords.clickOnElement(PropertiesFile.getLocator("openDropdown")[0], PropertiesFile.getLocator("openDropdown")[1]);
		log.info("Drop down open successfully");
			
	}
	
	@Test(priority = 11)
	public void verifyValidUsername() {
		log.info("Verify valid Username");
		String expected="Amazon Sign In";
		Keywords.enterText(PropertiesFile.getLocator("userName")[0], PropertiesFile.getLocator("userName")[1], "bhasmeminal@gmail.com");
		log.info("Username enter successfully");
		String actual=Constants.driver.getTitle();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 12, dependsOnMethods = { "verifyValidUsername" })
	public void verifyContinueButtonClickable() {
		log.info("*** Verify Continue button clickable ***");
		String expected="https://www.amazon.in/ap/signin";
		Keywords.clickOnElement(PropertiesFile.getLocator("continueBtnClk")[0], PropertiesFile.getLocator("continueBtnClk")[1]);
		log.info("Click continue button");
		String actual=Constants.driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
		log.info("Continue button clicked successfully and password field is open");
	}
	
	@Test(priority = 13)
	public void verifyPasswordLabel() {
		log.info("*** Verify Password label ***");
		boolean b5=Keywords.isElementDisplay(PropertiesFile.getLocator("passwordLabel")[0], PropertiesFile.getLocator("passwordLabel")[1]);
		Assert.assertTrue(b5);
		log.info("Password label successfully display above password field");
	}
	
	@Test(priority = 14)
	public void verifyPasswordField() {
		log.info("*** Verify password field ***");
		boolean b5=Keywords.isElementDisplay(PropertiesFile.getLocator("pwdField")[0], PropertiesFile.getLocator("pwdField")[1]);
		Assert.assertTrue(b5);
		log.info("Password field successfully display below the password label");
	}
	
	@Test(priority = 15)
	public void verifyLoginButton() {
		log.info("*** Verify login button ***");
		boolean b6=Keywords.isButtonDisplay(PropertiesFile.getLocator("loginBtn")[0], PropertiesFile.getLocator("loginBtn")[1]);
		Assert.assertTrue(b6);
		log.info("login button successfully displayed on sign in page");
	}
	
	@Test(priority = 16, dependsOnMethods = { "verifyContinueButtonClickable" })
	public void verifyValidPassword() {
		log.info("*** Verify valid password ***");
		Keywords.enterText(PropertiesFile.getLocator("password")[0], PropertiesFile.getLocator("password")[1], "minalketan");
		log.info("Password enter successfully");
		String expected="Amazon Sign In";
		String actual=Constants.driver.getTitle();
		Assert.assertEquals(actual, expected);

	}
	
	@Test(priority = 17, dependsOnMethods = { "verifyValidPassword" })
	public void verifyLoginButtonClickable() {
		log.info("*** Verify Login button clickable ***");
		Keywords.clickOnElement(PropertiesFile.getLocator("loginBtnClk")[0], PropertiesFile.getLocator("loginBtnClk")[1]);
		log.info("Click Login button");
		String expected="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actual=Constants.driver.getTitle();
		Assert.assertEquals(actual, expected);
		log.info("After successfully login open amazon home page");
	}
}
