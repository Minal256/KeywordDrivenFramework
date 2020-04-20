package com.amazon.keywords;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Keywords {

	public static void openBrowser(String browsername) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		switch (browsername) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			Constants.driver = new ChromeDriver(options); // constants pass bcoz in that class instances var of
															// webdriver initialized
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
			System.err.println("Invalid Browser name" + browsername);
			break;
		}
	}

	public static void launchUrl(String url) {
		Constants.driver.get(url);
	}

	public static void maximizeBrowser() {
		Constants.driver.manage().window().maximize();
	}

	public static WebElement getWebElement(String locatorType, String locatorValue) {
		WebElement element = null; // create web element instance

		switch (locatorType) {
		case "XPATH":
			element = Constants.driver.findElement(By.xpath(locatorValue));
			break;

		case "CSS":
			element = Constants.driver.findElement(By.cssSelector(locatorValue));
			break;

		case "ID":
			element = Constants.driver.findElement(By.id(locatorValue));
			break;

		case "CLASS_NAME":
			element = Constants.driver.findElement(By.className(locatorValue));
			break;

		case "LINK_TEXT":
			element = Constants.driver.findElement(By.linkText(locatorValue));
			break;

		case "PARTIAL_LINK_TEXT":
			element = Constants.driver.findElement(By.partialLinkText(locatorValue));
			break;

		case "NAME":
			element = Constants.driver.findElement(By.name(locatorValue));
			break;
		default:
			System.err.println("Invalid Loacator");
			break;
		}
		return element;
	}

	public static String getPageTitle() {
		String title = Constants.driver.getTitle();
		return title;
	}

	public static boolean isLogoDisplay(String locatorType, String locatorValue) {
		boolean logo = getWebElement(locatorType, locatorValue).isDisplayed();
		return logo;
	}

	public static String getElementLabelColor(String locatorType, String locatorValue) {
		String labelColor = getWebElement(locatorType, locatorValue).getCssValue("color");
		String hexcolor = Color.fromString(labelColor).asHex();
		return hexcolor;
	}

	public static boolean isElementDisplay(String locatorType, String locatorValue) {
		boolean labelDisplay = getWebElement(locatorType, locatorValue).isDisplayed();
		return labelDisplay;
	}

	public static boolean isButtonDisplay(String locatorType, String locatorValue) {
		boolean buttonDisplay = getWebElement(locatorType, locatorValue).isDisplayed();
		return buttonDisplay;
	}

	public static String getButtonColor(String locatorType, String locatorValue) {
		String buttoncolor = getWebElement(locatorType, locatorValue).getCssValue("background-color");
		String hexcolor = Color.fromString(buttoncolor).asHex();
		System.out.println("Button Color is: " + hexcolor);
		return hexcolor;
	}

	public static String getButtonTextColor(String locatorType, String locatorValue) {
		String buttonTextColor = getWebElement(locatorType, locatorValue).getCssValue("color");
		String hexcolor = Color.fromString(buttonTextColor).asHex();
		System.out.println("Button text color: " + hexcolor);
		return hexcolor;
	}

	public static void clickOnElement(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}

	public static void enterText(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}

	public static void moveToElement(String locatorType, String locatorValue) { // for moving mouse
		Constants.action = new Actions(Constants.driver);
		// action.moveToElement(Constants.driver.findElement(By.cssSelector("a#nav-link-accountList.nav-a.nav-a-2")));
		Constants.action.moveToElement(getWebElement(locatorType, locatorValue));
		Constants.action.perform(); // que.-where use build nd perform

	}

	public static void switchOnWindow(String locatorType, String locatorValue) {
		Constants.parentHandle = Constants.driver.getWindowHandle(); // parent window handle

		WebElement childHandle = getWebElement(locatorType, locatorValue);
		childHandle.click();
		Set<String> allChildWindows = Constants.driver.getWindowHandles();
		System.out.println("Child window handle:" + allChildWindows);

		for (String child : allChildWindows) {
			if (!Constants.parentHandle.equalsIgnoreCase(child)) {
				Constants.driver.switchTo().window(child);
			}
		}
	}
	
	public static void captureHalfPageScreenShot(String testMethodName) {

		File scr = ((TakesScreenshot) Constants.driver).getScreenshotAs(OutputType.FILE);

		String filename = new SimpleDateFormat("yyyyMMdd_hhmmss'.png'").format(new Date());

		System.out.println("" + filename);
		File dest = new File("Screenshots//HalfPageScreenShot/" + filename + testMethodName);

		try {
			FileUtils.copyFile(scr, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("" + dest);

	}

	public static void captureFullPageScreenShot() {
		AShot ashot = new AShot();
		ashot.shootingStrategy(ShootingStrategies.viewportPasting(3000));

		Screenshot src = ashot.takeScreenshot(Constants.driver);
		BufferedImage image = src.getImage();
		// =================== OR ======================//
		// BufferedImage
		// img1=ashot.shootingStrategy(ShootingStrategies.viewportPasting(3000)).takeScreenshot(driver).getImage();
		String filename = new SimpleDateFormat("yyyyMMdd_hhmmss'.png'").format(new Date());
		try {

			ImageIO.write(image, "PNG", new File(
					"E:\\Eclipse programs\\KeywordDrivenFramework\\Screenshots\\FullPageScreenShot/" + filename));

		} catch (IOException e) {
			System.out.println("File path not found");
			e.printStackTrace();
		}
	}

	public static void pageScrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) Constants.driver;
		js.executeScript("window.scrollBy(0,2000)", "");
	}

	public static void pageScrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) Constants.driver;
		js.executeScript("window.scrollBy(0,-2500)", "");
	}
	
	public static void closeBrowser() {
		Constants.driver.quit();
	}

}
