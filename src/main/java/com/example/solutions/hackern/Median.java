package com.example.solutions.hackern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Median {
	
	public static void main(String[] args) {
		List list = new ArrayList<>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(6);
		list.add(4);
		System.out.println(findMedian(list));
		
	}
	
	  public static int findMedian(List<Integer> arr) {
		  arr = arr.stream().sorted().collect(Collectors.toList());
		  int middle = arr.size() % 2 == 0 ? arr.size() / 2 : (arr.size() / 2)+ 1;
		  return arr.get(middle);
	  }

}
