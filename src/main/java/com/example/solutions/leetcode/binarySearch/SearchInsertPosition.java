package com.example.solutions.leetcode.binarySearch;

import java.util.Arrays;

public class SearchInsertPosition {

	public static void main(String[] args) {
		SearchInsertPosition search = new SearchInsertPosition();
		int[] nums = {1,3,5,6};
		int target = 2;
		System.out.println(search.searchInsert(nums, target));
		
	}
    public int searchInsert(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if(index < 0) {
        	int[] newArr = Arrays.copyOf(nums,nums.length + 1);
        	newArr[nums.length] = target;
        	Arrays.sort(newArr);
        	return Arrays.binarySearch(newArr, target);
        }
        return index;
    }
    
}
