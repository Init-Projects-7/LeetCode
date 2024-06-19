package com.example.solutions.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Remove Duplicates
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&envId=top-interview-150">Task Description</a> 
 * @author Sattar
 *
 */

public class RemoveDuplicates {
	
    public static void main(String[] args) {
    	int[] nums = {1,4,5,1,5,5};
    	RemoveDuplicates task = new RemoveDuplicates();
    	System.out.println(task.removeDuplicates(nums));
    }
    
    public int removeDuplicates(int[] nums) {
      	int[] arr1 = Arrays.stream(nums).distinct().toArray(); 	    	
    	for(int i = 0; i<arr1.length;i++) {
	        nums[i] = arr1[i];
	     }
	    return arr1.length;
    }
}
