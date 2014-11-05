package com.jlrc.java;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONArray;

public class CsvTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length == 0){
			System.out.println("No location provided");
			return;
		}
		String place = args[0].toString();
		ApiJsonReader reader = new ApiJsonReader(place);
		
		JSONArray json;
		try {
			json = reader.readJsonFromUrl();
			CsvFileCreator csv = new CsvFileCreator(json);
			csv.createCsvFile();
			System.out.println("Csv file created!!");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			System.out.println("Error parsing the JSON response");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Csv couldnt be created!!");
		}
		
		
		
	    
		
	}

}
