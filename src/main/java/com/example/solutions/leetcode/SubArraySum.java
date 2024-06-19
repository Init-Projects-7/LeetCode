package com.example.solutions.leetcode;

import java.util.Arrays;

/**
 * Minimum Size Subarray Sum
 * <a href="https://leetcode.com/problems/minimum-size-subarray-sum/">Task Description</a> 
 * @author Sattar
 *
 */

public class SubArraySum {

	public static void main(String[] args) {
		SubArraySum subArray = new SubArraySum();
		int[] gas = {1,2,3,4,5,17};
		int target = 15;
		System.out.println(subArray.minSubArrayLen(target, gas));
	}
	
    public int minSubArrayLen(int target, int[] nums) {
    	Arrays.sort(nums);
    	
    	int totalSum = Arrays.stream(nums).reduce(0, Integer::sum);
    	if(totalSum < target) return 0;
    	else if(Arrays.binarySearch(nums, target) > 0 ) return 1;    	
    	else if(this.twoSteps(target, nums))return 2;
    	else return this.subArrays(nums, target);
    
    	
    }
    
    public int subArrays(int[] nums, int target) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left++];
            }
        }

        return (minLength != Integer.MAX_VALUE) ? minLength : 0;
    }

	public boolean twoSteps(int target, int[] nums) {
    	int i = 0;
    	int j = nums.length-1;
		if(nums[j-1] + nums[j] < target) {
			return false;
		}
    	while(i!=j) {
    		if(nums[i] + nums[j] == target) {
    			return true;
    		}else if(nums[i] + nums[j] > target) {
    			j--;
    		}else {
    			i++;
    		}
    	}
    	return false;
    }
    
  
}
