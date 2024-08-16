package com.example.inst.discover.assync;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;


public class RecursiveWordCall  extends RecursiveTask<List>{

	private String link;	
	
	public RecursiveWordCall(String link) {
		this.link = link;
	}
	
	@Override
	protected List compute() {
		ArrayList<String> wordLinks = new ArrayList<>();
        HttpURLConnection connection = null;
        try {
            URL url = new URL(this.link);
            System.out.println("Working for = "+this.link);
            connection = (HttpURLConnection) url.openConnection();
            
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                
                in.close();
                
                try (JsonReader jsonReader = Json.createReader(new StringReader(response.toString()))) {
                    JsonArray jsonArray = jsonReader.readArray();
                    for (JsonValue jsonValue : jsonArray) {
                    	JsonObject jsonObject = jsonValue.asJsonObject();
                    	wordLinks.add(jsonObject.getString("de"));             	
                    }
                    return wordLinks;
                }
            } else {
                System.out.println("ERROR GET request for words with = "+this.link);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        wordLinks.add("ERROR");
        return wordLinks;
	
	}


}