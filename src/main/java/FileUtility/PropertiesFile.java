package FileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.amazon.keywords.Constants;

public class PropertiesFile {

	public static String getProperty(String key) 
	{
		String value=null;
		try {
			Constants.fis=new FileInputStream("E:\\Eclipse programs\\KeywordDrivenFramework\\src\\main\\resources\\OR.properties");
            Constants.prop=new Properties();
            Constants.prop.load(Constants.fis);
            value=Constants.prop.getProperty(key);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Unable to open repository");
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
	public static String getProperty(String key,String filepath) 
	{
		String value=null;
		try {
			Constants.fis = new FileInputStream(filepath);
			Constants.prop=new Properties();
			Constants.prop.load(Constants.fis);
            value=Constants.prop.getProperty(key);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File"+filepath+"not found");
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			System.out.println("unable to load File"+filepath);
			e.printStackTrace();
		}
		return value;	
	}
	public static String[] getLocator(String key)
	{
		String[] value=null;
		try {
			Constants.fis=new FileInputStream("E:\\Eclipse programs\\KeywordDrivenFramework\\src\\main\\resources\\OR.properties");
			Constants.prop=new Properties();
			Constants.prop.load(Constants.fis);
            String part=Constants.prop.getProperty(key);
            value=part.split("##");
            System.out.println("Locator Type:"+value[0]);
            System.out.println("Locator Value:"+value[1]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return value;	
	}
}