package com.example.solutions.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Link: https://leetcode.com/problems/ransom-note/?envType=study-plan-v2&envId=top-interview-150
 * @author aqccj
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * Each letter in magazine can only be used once in ransomNote.
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
    	char[] ransomCharArr = ransomNote.toCharArray();
    	List<String> ransomList = IntStream.range(0, ransomCharArr.length)
                .mapToObj(i -> String.valueOf(ransomCharArr[i]))
                .collect(Collectors.toList());
    	
    	char[] magazineCharArr = magazine.toCharArray();
    	List<String> magazineList = IntStream.range(0, magazineCharArr.length)
                .mapToObj(i -> String.valueOf(magazineCharArr[i]))
                .collect(Collectors.toList());
    	
        List<String> result = ransomList.stream()
                .filter(s -> {
                   
                    if (magazineList.contains(s)) {
                    	magazineList.remove(s);
                        return false;
                    }
                    return true;
                })
                .collect(Collectors.toList());
        return result.size() == 0;
    }
    
    public static void main(String[] args) {
		String ransomNote = "a";
		String magazine = "seekjfammbktpptakkjnr";
	}
}
