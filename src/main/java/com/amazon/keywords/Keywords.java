package com.amazon.keywords;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
 
import io.github.bonigarcia.wdm.WebDriverManager;

public class Keywords {

	public static void openBrowser(String browsername) { 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		switch (browsername) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			Constants.driver = new ChromeDriver(options); //constants pass bcoz in that class instances var of webdriver initialized
			break;
			
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			Constants.driver = new FirefoxDriver();
			break;
			
		case "IE":
			WebDriverManager.iedriver().setup();
			Constants.driver = new InternetExplorerDriver();
			break;
			
		case "Safari":
			Constants.driver = new SafariDriver();
			break;
			
		default:
			System.err.println("Invalid Browser name"+browsername);
			break;
			}
		}
	
	public static void launchUrl(String url) {
		Constants.driver.get(url); 
	}
	
	public static void maximizeBrowser() {
		Constants.driver.manage().window().maximize();
	}
	
	public static WebElement getWebElement(String locatorType , String locatorValue) {	
		WebElement element =null; //create web element instance
		
		switch (locatorType) {
		case "XPATH":
			element=Constants.driver.findElement(By.xpath(locatorValue));
			break;
			
		case "CSS":
			element=Constants.driver.findElement(By.cssSelector(locatorValue));
			break;
			
		case "ID":
			element=Constants.driver.findElement(By.id(locatorValue));
			break;
			
		case "CLASS_NAME":
			element=Constants.driver.findElement(By.className(locatorValue));
			break;
			
		case "LINK_TEXT":
			element=Constants.driver.findElement(By.linkText(locatorValue));
			break;
			
		case "PARTIAL_LINK_TEXT":
			element=Constants.driver.findElement(By.partialLinkText(locatorValue));
			break;
			
		case "NAME":
			element=Constants.driver.findElement(By.name(locatorValue));
			break;
		default:
			System.err.println("Invalid Loacator");
			break;
		}
		return element;
	}
	
	public static String pageTitle() {
		String title = Constants.driver.getTitle();
		return title;
	}
	
	public static boolean logoDisplay(String locatorType , String locatorValue) {
		boolean logo = getWebElement(locatorType, locatorValue).isDisplayed();
		return logo;
	}
	
	public static String elementColor(String locatorType, String locatorValue) {
		String elementColor = getWebElement(locatorType, locatorValue).getCssValue("color");
		String hexcolor = Color.fromString(elementColor).asHex();
		return hexcolor;
	}
	
	public static String logoColor(String locatorType, String locatorValue) {
		String logoColor=elementColor(locatorType, locatorValue);
		return logoColor;
	}
	
	public static String labelColor(String locatorType, String locatorValue) {
		String labelColor=elementColor(locatorType, locatorValue);
		return labelColor;
	}
	
	public static boolean elementLabelDisplay(String locatorType , String locatorValue) {
		boolean labelDisplay = getWebElement(locatorType, locatorValue).isDisplayed();
		return labelDisplay;
	}
	
	public static boolean buttonDisplay(String locatorType , String locatorValue) {
		boolean buttonDisplay = getWebElement(locatorType, locatorValue).isDisplayed();
		return buttonDisplay;
	}
	
	public static String buttonColor(String locatorType , String locatorValue) {
		String buttoncolor = getWebElement(locatorType, locatorValue).getCssValue("background-color");
		String hexcolor = Color.fromString(buttoncolor).asHex();
		System.out.println("Button Color is: "+ hexcolor);
		return hexcolor;
	}
	
	public static String buttonTextColor(String locatorType , String locatorValue) {
		String buttonTextColor = getWebElement(locatorType, locatorValue).getCssValue("color");
		String hexcolor = Color.fromString(buttonTextColor).asHex();
		System.out.println("Button text color: "+ hexcolor);
		return hexcolor;	 
	}
	
	public static void clickOnElement(String locatorType , String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}
	
	public static void enterText(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}
	
	public static void moveToElement(String locatorType, String locatorValue) {  //for moving mouse
		Actions action = new Actions(Constants.driver);
		//action.moveToElement(Constants.driver.findElement(By.cssSelector("a#nav-link-accountList.nav-a.nav-a-2")));
		action.moveToElement(getWebElement(locatorType, locatorValue));
		action.perform(); //que.-where use build nd perform

	}
	
	public static void windowHandleInNewTab(String locatorType, String locatorValue) {
		String parentHandle=Constants.driver.getWindowHandle(); //parent window handle
		
		WebElement childHandle = getWebElement(locatorType, locatorValue);
		childHandle.click();
		Set<String> allChildWindows = Constants.driver.getWindowHandles();
		System.out.println("Child window handle:"+allChildWindows);
		
		for(String child : allChildWindows)
		{
			if(!parentHandle.equalsIgnoreCase(child))
			{
				Constants.driver.switchTo().window(child);
			}
		}
	}
	
	public static ArrayList<String> iconNavBarItems(String locatorType, String locatorValue) {
		List<WebElement> subNavItems=(List<WebElement>) getWebElement(locatorType, locatorValue);
		
		ArrayList<String> actualSubNavItems=new ArrayList<String>();
		Iterator<WebElement> itr=subNavItems.iterator();
		while (itr.hasNext()) {
			actualSubNavItems.add(itr.next().getText());	
		}
		return actualSubNavItems;
	}
	
	
}


