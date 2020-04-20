package com.amazon.keywords;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.xml.Parser;

public class ReadJSON {
	
	public static  void readJsonFile(String topicname) {
		
		//---- Create JSON parser Object -----//
		JSONParser  jParser = new JSONParser();
		
		//--- Create file reader object to read file ---//
		try {
		//	FileReader reader = new FileReader(".\\src/main/resources\\ExpectedHelpTopics.json");
			
			//--------- parse json file ---------//
			Object JavaObj = jParser.parse(new FileReader("E:\\Eclipse programs\\KeywordDrivenFramework\\src\\main\\resources\\ExpectedHelpTopics.json"));
			
			//----- From javaobj we need to extract the JSONObject -----------//
			JSONObject jObject= (JSONObject)JavaObj;
			
			//----- Extract jsonArray From json Object -----------//
			JSONArray jArray = (JSONArray) jObject.get("Recommended Topics");
			
		//	JSONArray jArray = (JSONArray) jObject.get(topicname); //topic name which having json data
			System.out.println(jArray);
			
//			JSONArray jArray1 = (JSONArray) jObject.get(topicname);
//			System.out.println(jArray1);
//			for (int i = 0; i < jArray1.size(); i++) {
//				System.out.println(jArray1.get(i));
//			}
			
			for (int i = 0; i < jArray.size(); i++) {
				System.out.println(jArray.get(i));
			}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
	//	readJsonFile("Shipping & Delivery");
		readJsonFile("Recommended Topics");
	}

}
