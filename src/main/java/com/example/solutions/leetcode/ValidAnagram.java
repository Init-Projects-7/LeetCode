package com.example.solutions.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ValidAnagram {
	
	public static void main(String[] args) {
		ValidAnagram validAnagram = new ValidAnagram();
		String s = "anagram";
		String t = "nagaram";
		System.out.println(validAnagram.isAnagram(s, t));
		
	}
	
    public boolean isAnagram(String s, String t) {
    	String sorted = Arrays.stream(s.split("")).sorted().collect(Collectors.joining());
    	String sorted2 = Arrays.stream(t.split("")).sorted().collect(Collectors.joining());
        return sorted.equalsIgnoreCase(sorted2);
    }

}
