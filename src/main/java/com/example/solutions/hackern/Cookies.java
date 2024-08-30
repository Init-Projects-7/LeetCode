package com.example.solutions.hackern;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Cookies {
	
	
    public static int cookies(int k, List<Integer> cookieSet) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(cookieSet);

        int counter = 0;

        while (minHeap.size() > 1 && minHeap.peek() < k) {

            int leastSweet = minHeap.poll();
            int secondLeastSweet = minHeap.poll();

           
            int newSweetness = leastSweet + 2 * secondLeastSweet;
            minHeap.offer(newSweetness);

            counter++;
        }

        if (minHeap.peek() >= k) {
            return counter;
        } else {
            return -1;
        }
    }
    
    public static int sumChecker(Integer a, Integer b) {
    	return a + 2*b;
    }
    
    public static void main(String[] args) {
		List<Integer> cookies = new ArrayList<>();
		cookies.add(1);
		cookies.add(2);
		cookies.add(3);
		cookies.add(9);
		cookies.add(10);
		cookies.add(12);
		cookies(7, cookies);
	}
}
