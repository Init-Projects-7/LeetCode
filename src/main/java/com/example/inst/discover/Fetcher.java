package com.example.inst.discover;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import com.example.inst.discover.assync.RecursiveWordCall;

public class Fetcher {
	
	public String readingGeneral = "https://sideprojects-777.github.io/DatabaseDE/data/reading/CITYNAME";		
	public String listenGeneral = "https://sideprojects-777.github.io/DatabaseDE/data/listening/CITYNAME";
	
	public static void main(String[] args) {
		Fetcher fetch = new Fetcher();
		ArrayList<String> links = fetch.getWordLinks();		
		//fetch.printLink(links);
		int amountOfThreads = Runtime.getRuntime().availableProcessors();
		ForkJoinPool pool = new ForkJoinPool(amountOfThreads);
		List<String> allWords = Collections.synchronizedList(new ArrayList<>());
		for(String wordLink:links) {
			RecursiveWordCall wordCaller = new RecursiveWordCall(wordLink);
			allWords.addAll(pool.invoke(wordCaller));
		}
		
        Map<String, Integer> nameCountMap = allWords.stream()
                .collect(Collectors.toMap(
                        name -> name, // Key Mapper: the string itself
                        name -> 1,    // Value Mapper: start with count 1
                        Integer::sum, // Merge Function: sum counts for duplicates
                        HashMap::new  // Supplier: create a new HashMap
                ));
        Map<String, Integer> filteredMap = nameCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,  // Key Mapper
                        Map.Entry::getValue, // Value Mapper
                        (existing, replacement) -> existing, // Merge Function (should not occur as keys are unique)
                        HashMap::new // Supplier: create a new HashMap
                ));
        
        filteredMap.entrySet().stream().sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
        	.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

	}
	
	public void printLink(ArrayList<String> links) {
		links.stream().forEach(System.out::println);
	}
	
	public ArrayList<String> getWordLinks() {
		ArrayList<String> cities = getCities();
		ArrayList<String> wordLinks = new ArrayList<>();
		for(String city: cities) {
			String readingLink =  this.readingGeneral.replace("CITYNAME", city);
			String listeningLink = this.listenGeneral.replace("CITYNAME", city);
			List<String> readingFiles = fetchWordEndpoints(readingLink+"/index.json");
			List<String> listeningFiles = fetchWordEndpoints(listeningLink+"/index.json");
			readingFiles = readingFiles.stream().map( x -> Fetcher.concatReadingString(x,city,"reading")).collect(Collectors.toList());
			listeningFiles = listeningFiles.stream().map( x -> Fetcher.concatReadingString(x,city,"listening")).collect(Collectors.toList());
			wordLinks.addAll(readingFiles);
			wordLinks.addAll(listeningFiles);
		}
		return wordLinks;
	}
	
	public static String concatReadingString(String x,String city, String modeType) {
		String readingLink = "https://sideprojects-777.github.io/DatabaseDE/data/MODETYPE/CITYNAME";
		readingLink =  readingLink.replace("CITYNAME", city);
		readingLink =  readingLink.replace("MODETYPE", modeType);
		return readingLink+"/words/"+x;
	}
	
	
	public ArrayList<String> getCities() {
		ArrayList<String> links = new ArrayList<>();
		links.add("cologne");
		links.add("bonn");
		links.add("dusseldorf");
		links.add("einfach");
		links.add("koblenz");
		return links;
	}
	
	public static ArrayList<String> fetchWordEndpoints(String urlString){
			ArrayList<String> wordLinks = new ArrayList<>();
	        HttpURLConnection connection = null;
	        try {
	            URL url = new URL(urlString);
	            
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
	                    	wordLinks.add(jsonObject.getString("words"));             	
	                    }
	                    return wordLinks;
	                }
	            } else {
	                System.out.println("GET request not worked");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (connection != null) {
	                connection.disconnect();
	            }
	        }
	        return null;
	   }
	
	
	
}

	


