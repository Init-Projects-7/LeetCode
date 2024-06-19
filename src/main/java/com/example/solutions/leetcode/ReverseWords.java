package com.example.solutions.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Reverse Words in a String
 * <a href="https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150">Task Description</a> 
 * @author Sattar
 *
 */
public class ReverseWords {

	public static void main(String[] args) {
		ReverseWords reverse = new ReverseWords();
		String myString = "a  good   example ";
		System.out.println(reverse.reverseWords(myString));
	}
	
    public String reverseWords(String s) {
    	s = s.trim();
    	String[] cutted = Arrays.stream(s.split(" ")).filter(x -> !x.equalsIgnoreCase(" ") && !x.equalsIgnoreCase("")).toArray(String[]::new);
    	List<String> list = Arrays.asList(cutted);
        Collections.reverse(list);        
    	return list.stream().collect(Collectors.joining(" "));
    }
}
