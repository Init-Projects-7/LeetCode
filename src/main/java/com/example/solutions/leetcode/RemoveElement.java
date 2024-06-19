package com.example.solutions.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
	import java.util.stream.IntStream;

/**
 * Remove Element
 * <a href="https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150">Task Description</a> 
 * @author Sattar
 *
 */

public class RemoveElement {
	
    public static void main(String[] args) {
    	int[] nums = {1,4,5,1,5,5};
    	int val = 5;
    	RemoveElement task = new RemoveElement();
    	System.out.println(task.removeElement(nums, val));
    }
    
    public int removeElement(int[] nums, int val) {
	        int[] arr1 = Arrays.stream(nums).filter(x -> x!=val).toArray();
	        int[] arr2 = Arrays.stream(nums).filter(x -> x==val).toArray();        
	        int[] finalAnswer = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).toArray();
	        for(int i = 0; i<nums.length;i++) {
	        	nums[i] = finalAnswer[i];
	        }
	    	return arr1.length;
    }
}
