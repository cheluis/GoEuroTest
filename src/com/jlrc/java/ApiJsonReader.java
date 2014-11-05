package com.jlrc.java;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONArray;



public class ApiJsonReader {
	final String apiUrl = "http://api.goeuro.com/api/v2/position/suggest/en/";
	private String place;
	private String endPointUrl;
	public ApiJsonReader(String place){
		this.place = place;
		this.endPointUrl = this.apiUrl + this.place;
	}
	
	private static String readFromBuffer(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }

	  public JSONArray readJsonFromUrl() throws IOException, JSONException {
	    InputStream is = new URL(this.endPointUrl).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readFromBuffer(rd);
	      JSONArray json = new JSONArray(jsonText);
	      return json;
	    } finally {
	      is.close();
	    }
	  }


}
