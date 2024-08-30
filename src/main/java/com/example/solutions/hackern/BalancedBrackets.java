package com.example.solutions.hackern;

import java.util.HashMap;

public class BalancedBrackets {	
	
	
    public static String isBalanced(String s) {
    	HashMap<String, String> bracketMap = init();
    	if(s.length() % 2 != 0) return "NO";
    	int rightNode = s.length() / 2;
    	int leftNode = rightNode - 1;
    	try {
        	while(leftNode !=0) {
        		String requiredRightNode =  bracketMap.get(String.valueOf(s.charAt(leftNode)));
        		String gottenRightNode = String.valueOf(s.charAt(rightNode));
        		if(!requiredRightNode.equalsIgnoreCase(gottenRightNode)) {
        			return "NO";
        		}
        		leftNode--;
        		rightNode++;
        	}
        	return "YES";
    	} catch (NullPointerException e) {
    		return "NO";
		}    	
    }
    
    public static String isBalanced(String s, String r1) {
    	HashMap<String, String> bracketMap = init();
    	if(s.length() % 2 != 0) return "NO";
    	char[] charArray = s.toCharArray(); 
    	boolean swapping = true;
    	while(swapping) {
    		swapping = false;
    		for(int i = 0; i<charArray.length-1; i++){
    			String parsedValue = String.valueOf(charArray[i]);
    			if(bracketMap.containsKey(parsedValue)) {
    				String requiredRightSide = bracketMap.get(parsedValue);
    				String passedRightSide = String.valueOf(charArray[i+1]);
    				if(passedRightSide.equalsIgnoreCase(requiredRightSide)) {
    					s = s.substring(0, i) + s.substring(i + 2);
    					swapping = true;
    					break;
    				}
    			}			
    			
    		}
    		 charArray = s.toCharArray();
    	}
    	return s.length() == 0? "YES" : "NO";
    }
    
    public static HashMap<String, String> init(){
    	HashMap<String, String> bracketMap = new HashMap<>();
		bracketMap.put("(", ")");
		bracketMap.put("[", "]");
		bracketMap.put("{", "}");
		return bracketMap;
    }
    
    
	public static void main(String[] args) {
		String b1 = "{{([])}}";
		String b2 = "{(([])([])[]}[]}";
		//System.out.println(isBalanced(b1));
		System.out.println(isBalanced(b2," "));
	}

}
