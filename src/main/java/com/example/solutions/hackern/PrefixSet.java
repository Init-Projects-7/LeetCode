package com.example.solutions.hackern;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PrefixSet {
	
    public static void noPrefix(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
       for (int j = 0; j < i; j++) {
           String word1 = words.get(i);
           String word2 = words.get(j);
           if(word2.startsWith(word1) || word1.startsWith(word2)){
               System.out.println("BAD SET");
               System.out.println(word1);
               return;
           }
       }
    }
    System.out.println("GOOD SET");
    	

    }

    
    public static void main(String[] args) {
		
        List<String> stringList = new ArrayList<>();

        // Add elements to the list
        stringList.add("aab");
        stringList.add("aac");        
        stringList.add("aace");
        stringList.add("aabe");
        noPrefix(stringList);
	}
}
