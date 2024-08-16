package com.example.solutions.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 * @author aqccj
 *
 */
public class PhoneNumber {
		
	
    public List<String> letterCombinations(String digits) {
    	
    	if(digits.length() == 0) return new ArrayList<>();
    	HashMap<String, List<String>> phoneKeypad = init();
        if(digits.length() == 1) return phoneKeypad.get(digits);
        char[] charArray = digits.toCharArray();
        List<String> list1 = phoneKeypad.get(String.valueOf(charArray[0]));
        List<String> list2 = phoneKeypad.get(String.valueOf(charArray[1]));
        List<String> result = list1.stream()
                .flatMap(s1 -> list2.stream()
                    .map(s2 -> s1 + s2))
                .collect(Collectors.toList());
        
        if(digits.length() == 2) return result;
        
        List<String> threeResult = result.stream()
        .flatMap(s1 -> phoneKeypad.get(String.valueOf(charArray[2])).stream()
                .map(s2 -> s1 + s2))
            .collect(Collectors.toList());
        if(digits.length() == 3) return threeResult;
        
        List<String> fourResult = threeResult.stream()
        .flatMap(s1 -> phoneKeypad.get(String.valueOf(charArray[3])).stream() 
                .map(s2 -> s1 + s2))
            .collect(Collectors.toList());
        return fourResult;
    }
    
    public static HashMap<String, List<String>> init(){
        HashMap<String, List<String>> phoneKeypad = new HashMap<>();

        phoneKeypad.put("2", Arrays.asList("a", "b", "c"));
        phoneKeypad.put("3", Arrays.asList("d", "e", "f"));
        phoneKeypad.put("4", Arrays.asList("g", "h", "i"));
        phoneKeypad.put("5", Arrays.asList("j", "k", "l"));
        phoneKeypad.put("6", Arrays.asList("m", "n", "o"));
        phoneKeypad.put("7", Arrays.asList("p", "q", "r", "s"));
        phoneKeypad.put("8", Arrays.asList("t", "u", "v"));
        phoneKeypad.put("9", Arrays.asList("w", "x", "y", "z"));
        
        return phoneKeypad;
    }
    
    
    public static void main(String[] args) {
		
	}

}
