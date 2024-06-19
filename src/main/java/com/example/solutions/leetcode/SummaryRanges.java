package com.example.solutions.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Summary Ranges
 * <a href="https://leetcode.com/problems/summary-ranges/description/?envType=study-plan-v2&envId=top-interview-150">Task Description</a> 
 * @author Sattar
 *
 */
public class SummaryRanges {
	
	public static void main(String[] args) {
		SummaryRanges summaryRange = new SummaryRanges();
		int[] arr = {};
		summaryRange.summaryRanges(arr).forEach(System.out::println);
		System.out.println();
		//System.out.println();		
	}
	
    public List<String> summaryRanges(int[] nums) {
        List<String> answer = new ArrayList<>();
        if(nums.length==0) {
        	return answer;
        }
        int initVal = nums[0];
        String initString = String.valueOf(initVal);
        boolean firstEntry = true;
        for(int i=1;i<nums.length;i++) {
        	//System.out.println(initVal + " / "+nums[i]);
        	if(initVal + 1==nums[i]) {
        		if(firstEntry){
        			initString = String.valueOf(initVal) + "->"+String.valueOf(nums[i]);
        			firstEntry = false;
        		}else {
        			String head = initString.split("->")[0]; 
        			initString = head + "->" +String.valueOf(nums[i]);
        		}
        		//System.out.println(initString);
        		initVal = nums[i];        		
        	}else {
        		answer.add(initString);
        		initVal = nums[i];
        		initString = String.valueOf(initVal);
        		firstEntry = true;
        	}
        	
        	
        }
        answer.add(initString);
    	return answer;
    }

}
