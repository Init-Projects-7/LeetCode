package com.example.solutions.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Remove Duplicates
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&envId=top-interview-150">Task Description</a> 
 * @author Sattar
 *
 */

public class RemoveDuplicatesII {
	public static void main(String[] args) {
		int[] nums = {-3, -1,0,0,0,0,3,3};
    	RemoveDuplicatesII task = new RemoveDuplicatesII();
    	System.out.println(task.removeDuplicates(nums));
    	Arrays.stream(nums).forEach(System.out::println);
	}
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int index = 0; 
        int count = 1; 
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[index]) {
                if (count < 2) {
                    nums[++index] = nums[i]; 
                    count++;
                }
            } else {
                nums[++index] = nums[i]; 
                count = 1;
            }
        }
        return index + 1;
    }
}
