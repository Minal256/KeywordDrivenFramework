package com.amazon.keywords;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Constants {
	
	public static RemoteWebDriver driver;
	public static Actions action;
	public static String parentHandle;
	public static Properties prop;
	public static FileInputStream fis;
//	public static Logger log; 
}
