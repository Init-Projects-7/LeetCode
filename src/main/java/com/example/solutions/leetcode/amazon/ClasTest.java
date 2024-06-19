package com.example.solutions.leetcode.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.Collectors;

public class ClasTest {

	
	public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
	    PriorityQueue<Integer> pq = new PriorityQueue<>( (o1, o2) -> Integer.compare(o2, o1));
	    long totalWeight = 0;
	    for (Integer integer : arr) {
	        totalWeight += integer;
	        pq.offer(integer);
	    }
	    List<Integer> boxAElement = new ArrayList<>();
	    long currentWeight = 0;
	    for (int i = 0; i < arr.size(); i++) {
	        int highWeight = pq.poll();
	        currentWeight+= highWeight;
	        boxAElement.add(highWeight);
	        if(currentWeight> totalWeight-currentWeight){
	            break;
	        }
	    }
	    Collections.reverse(boxAElement);
	    return boxAElement;
	}
	
    public static List<Integer> minimalHeaviestSetA(List<Integer> arr, boolean tr) {
    	PriorityQueue<Integer> pq = new PriorityQueue<>( (o1, o2) -> Integer.compare(o2, o1));
	    for (Integer integer : arr) {
	        pq.offer(integer);
	    }
    	List<Integer> answerList = new ArrayList<>();
        Integer totalWeight = arr.stream().mapToInt(Integer::intValue).sum();
        arr = arr.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());  
        Integer gatheredWeight = 0;
        for (int i = 0; i < arr.size(); i++) {
        	int curr = pq.poll();
        	gatheredWeight = gatheredWeight + curr;
        	answerList.add(curr);
        	if(gatheredWeight > totalWeight - gatheredWeight) {
        		break;
        	}
        }
        return answerList.stream().sorted().collect(Collectors.toList());

    }
    
    public static List<Integer> duplicateElements(List<Integer> original, List<Integer> answer) {        
        Map<Integer, Integer> occurrenceMap = new HashMap<>();
        for (int num : original) {
            occurrenceMap.put(num, occurrenceMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int num : answer) {
            int occurrences = occurrenceMap.getOrDefault(num, 0);
            for (int i = 0; i < occurrences; i++) {
                result.add(num);
            }
        }

        return result;
    }
    
    
    public static void main(String[] args) {
		List list = new ArrayList<>();
		list.add(9);
		list.add(10);
		list.add(10);
		list.add(10);
		list.add(8);
		list.add(8);
		list.add(10);
		list.add(20);
		minimalHeaviestSetA(list,true).stream().forEach(System.out::println);
    	

	}
    

}
