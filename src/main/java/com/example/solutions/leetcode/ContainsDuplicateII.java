package com.example.solutions.leetcode;

import java.util.HashMap;

/**
 * Contains Duplicate II
 * <a href="https://leetcode.com/problems/contains-duplicate-ii/description/?envType=study-plan-v2&envId=top-interview-150">Task Description</a> 
 * @author Sattar
 *
 */

public class ContainsDuplicateII {
	
	public static void main(String[] args) {
		ContainsDuplicateII cDuplicate = new ContainsDuplicateII();
		int[] nums = {1,2,3,1};
		int k = 3;
	}
	
	
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i =0;i < nums.length;i++) {
        	if(map.containsKey(nums[i])) {
        		int firstIndex = map.get(nums[i]);
        		if(Math.abs(firstIndex - i)<=k) {
        			return true;
        		}else {
        			map.put(nums[i],i);
        		}
        	}else {
        		map.put(nums[i],i);
        	}
        }
        return false;
    }
}

