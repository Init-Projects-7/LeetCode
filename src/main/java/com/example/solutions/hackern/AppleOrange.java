package com.example.solutions.hackern;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

// https://www.hackerrank.com/challenges/apple-and-orange/problem?isFullScreen=true

/*
 * Complete the 'countApplesAndOranges' function below.
 *
 * The function accepts following parameters:
 *  1. INTEGER s
 *  2. INTEGER t
 *  3. INTEGER a
 *  4. INTEGER b
 *  5. INTEGER_ARRAY apples
 *  6. INTEGER_ARRAY oranges
 */
public class AppleOrange {
	
	public static void main(String[] args) {
		
	}
	
	  public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {

		  HashMap<Integer, Integer> houseLocation = new HashMap<>();
		  
		  for(int i=s;i<=t;i++) {
			  houseLocation.put(i, 0);
		  }
		  
		  List<Integer> fallenApples = apples.stream().map(app -> app + a).collect(Collectors.toList());
		  List<Integer> fallenOranges = oranges.stream().map(or -> or + b).collect(Collectors.toList());
		  
		  long countFallendApples = fallenApples.stream().filter(x -> houseLocation.containsKey(x)).count();
		  long countFallenOranges = fallenOranges.stream().filter(x -> houseLocation.containsKey(x)).count();
		  System.out.println(countFallendApples);
		  System.out.println(countFallenOranges);

	  }

}
