package com.jlrc.java;
import au.com.bytecode.opencsv.CSV;
import au.com.bytecode.opencsv.CSVWriteProc;
import au.com.bytecode.opencsv.CSVWriter;

import org.json.JSONObject;
import org.json.JSONArray;

public class CsvFileCreator {
	private final JSONArray jsonArray;
	private CSV csvFile;
	private final String fileName = "goEuro.csv";
	public CsvFileCreator(JSONArray jsonArray){
		this.jsonArray = jsonArray;
		this.csvFile = CSV
				.separator(',')  // delimiter of fields
				.quote('"')      // quote character
				.create();       // new instance is immutable
		
	}
	
	public void createCsvFile(){
		this.csvFile.write(this.fileName, new CSVWriteProc() {
		    public void process(CSVWriter out) {
		        out.writeNext("_id", "name", "type", "latitude", "longitude");
		    	for(int i = 0; i < jsonArray.length(); i++){
		        	JSONObject auxJsonObject = jsonArray.getJSONObject(i);
		        	JSONObject geoJsonObject = auxJsonObject.getJSONObject("geo_position");
		        	out.writeNext(auxJsonObject.get("_id").toString(), auxJsonObject.get("name").toString(), 
		        			auxJsonObject.get("type").toString(), geoJsonObject.get("latitude").toString(), 
		        			geoJsonObject.get("longitude").toString());
		        }
		   }
		});
	}

}
