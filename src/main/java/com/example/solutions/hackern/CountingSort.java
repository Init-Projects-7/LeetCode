package com.example.solutions.hackern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CountingSort {

	public static void main(String[] args) {
		int lengthArray = 4;
		List<Integer> arr = List.of(1,1,3,2,1);
		List<Integer> result = Solution.countingSort(arr);
		//result.stream().forEach(x -> System.out.print(x+" / "));
	}
}


class Solution {	
	
	  public static List<Integer> countingSort(List<Integer> arr) {
		  List<Integer> sorted = arr.stream().sorted().collect(Collectors.toList());
		  Integer[] ans = setup(100);
		  
		  sorted.stream().forEach(x -> increment(ans, x));
		  List<Integer> test = Arrays.asList(ans);
		  test.stream().forEach(x -> System.out.print(x+" / "));
		  return sorted;
	  }
	  
	  public static void increment(Integer[] ans, int currPosition) {
		  ans[currPosition] = ans[currPosition]+ 1;
	  }
	  
	  public static Integer[] setup(int length){
		  Integer[] ans = new Integer[length];
		  for(int i=0;i<length;i++) {
			  ans[i] = 0;
		  }
		  return ans;
	  }
}

