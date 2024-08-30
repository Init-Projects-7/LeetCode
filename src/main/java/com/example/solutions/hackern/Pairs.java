package com.example.solutions.hackern;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Pairs {
	
    public static int pairs(int k, List<Integer> arr) {
    	 Set<Integer> set = new HashSet<>(arr);
    	    int pairs = 0;

    	    for (Integer num : arr) {
    	        if (set.contains(num - k)) {
    	            pairs++;
    	        }
    	    }

    	    return pairs;
    }
	
	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();
		arr.add(5);
		arr.add(1);
		arr.add(4);
		arr.add(2);
		arr.add(3);
		System.out.println(pairs(2,arr));
	}

}
