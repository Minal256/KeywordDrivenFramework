package com.amazon.keywords;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadNavItemsList {

	@DataProvider(name="readCSV")
	public Iterator<Object[]> readCSVFile() {
		
		String path = "E:\\Eclipse programs\\KeywordDrivenFramework\\src\\main\\resources\\NavItemsOfAboutUsPage.csv";
		List<Object[]> NavItemsList = new ArrayList();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String []strarr;
			String lines="";
			try {
				while ((lines=br.readLine())!=null) {
					strarr=lines.split(",");
					NavItemsList.add(strarr);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NavItemsList.iterator();
	}
	
//	@Test(dataProvider = "readCSV")
//	public void verifyNavItemsList(String val) {
//		System.out.println(val);
//	}
}

