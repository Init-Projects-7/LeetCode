package com.example.solutions.tmp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProblemOne {

	public static void main(String[] args) {
		
		
		List<Integer> intList = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();
		intList.add(2);
		intList.add(3);
		intList.add(3);
		intList.add(4);
		intList.add(6);
		intList.add(8);
		intList.add(6);
		intList.add(8);
		
		tmp.add(2);
		tmp.add(6);
		tmp.add(6);
		tmp.add(2);
		tmp.add(3);
		tmp.add(5);
		
		
		int totalArea = getMaxTotalArea(intList);
        System.out.println("Total sum of areas of all rectangles: " + totalArea);
    }
	
	public static void print(Integer str) {
		System.out.print(str+" / ");
	}
	
	  public static int getMaxTotalArea(List<Integer> intList) {
		  //intList = intList.stream().sorted().collect(Collectors.toList());
		  List<Integer> newList = intList.stream().map(x -> x - 1).collect(Collectors.toList());		
		  List<Integer> finalList = Stream.concat(intList.stream(), newList.stream()).sorted()
                  .collect(Collectors.toList());
	      Map<Integer, Long> occurrences = finalList.stream()
	                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

	       List<Integer> removeList = occurrences.entrySet().stream()
	                .filter(entry -> entry.getValue() == 1)
	                .map(Map.Entry::getKey)
	                .collect(Collectors.toList());

	      finalList.removeIf(removeList::contains);
	      
	      
	      
	            
	      List<String> stringList = finalList.stream()
	                .map(Object::toString)
	                .collect(Collectors.toList());
	      String result = String.join("", stringList);
		  finalList = finalList.stream().distinct().collect(Collectors.toList());
		  int area = Integer.MIN_VALUE;
		  int sideA = 0;
		  int sideB = 0;
	      for(int i=0;i <finalList.size();i++) {
		      for(int j=i+1;j<finalList.size();j++) {
		    	  if(finalList.get(j) - finalList.get(i) == 1) {
		    		  char charValueA = (char) finalList.get(i).intValue();
		    		  char charValueB = (char) finalList.get(j).intValue();
		    		  long countA = result.chars().filter(ch -> ch == charValueA).count();
		    		  long countB = result.chars().filter(ch -> ch == charValueB).count();
		    		  if(countA > 2 && countB > 2) {
			    		  //System.out.println(finalList.get(i) + " / "+finalList.get(j));
			    		  //area = area + (finalList.get(i) * finalList.get(j));
			    		  if(largestArea(finalList.get(i), finalList.get(j), area)) {
			    			  area = finalList.get(i) * finalList.get(j);
			    			  sideA = finalList.get(i);
			    			  sideB = finalList.get(j);
			    		  }
		    		  }
		    	  }else {
		    		  //System.out.println(finalList.get(i) + " / "+finalList.get(j));
		    		  //area = area + (finalList.get(i) * finalList.get(j));
		    		  if(largestArea(finalList.get(i), finalList.get(j), area)) {
		    			  area = finalList.get(i) * finalList.get(j);
		    			  sideA = finalList.get(i);
		    			  sideB = finalList.get(j);
		    		  }
		    	  }
		      }  
	      }
	      System.out.println(sideA + " / "+sideB);
		  return area;
	  }
	  
	  
	  public static boolean largestArea(int a,int b, int target) {
		  return a*b >target;
	  }

}
