package com.example.solutions.hackern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridChallenge {


    public static String gridChallenge(List<String> grid) {
    	  String[][] sortedGrid = new String[grid.size()][grid.size()];

    	    for (int i = 0; i<grid.size(); i++) {
    	        String[] sorted = grid.get(i).split("");
    	        Arrays.sort(sorted);
    	        sortedGrid[i] = sorted;       
    	        if (i!=0) {
    	            for (int j=0; j<sorted.length; j++) {
    	                if (sortedGrid[i][j].compareTo(sortedGrid[i-1][j]) < 0) {                        
    	                      return "NO";
    	                }

    	            }
    	        }
    	    }

    	    return "YES";
    }
    
    public static String sortString(String str) {
        char[] characters = str.toCharArray();
        Arrays.sort(characters); 
        return new String(characters);
    }
    
    public static void columnGrid(List<String> grid) {
    	Map<Integer, String> columnGrid = new HashMap<>();
    	for(int i=0;i<grid.size();i++) {
    		columnGrid.put(i,"");
    	}
    }
    
    
    public static void main(String[] args) {
    	List<String> grid = new ArrayList<>();
    	grid.add("abc");
    	grid.add("kfq");
    	grid.add("mnz");
    	gridChallenge(grid);
	}
}
