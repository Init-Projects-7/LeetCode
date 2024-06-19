package com.example.solutions.hackern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://www.hackerrank.com/challenges/sock-merchant/problem?isFullScreen=true

public class SockMerchant {

    public static int sockMerchant(int n, List<Integer> pile) {
    	HashMap<Integer, Integer> socks = new HashMap<>();
    	   	
    	pile.stream().forEach(x -> socks.put(x, socks.getOrDefault(x, 0) + 1));
    	Integer sockPairs = 0;
        for (Map.Entry<Integer, Integer> entry : socks.entrySet()) {
            Integer count = entry.getValue();
            sockPairs+= count / 2; 
        }
    	
    	return sockPairs;

    }
    
    public static void main(String[] args) {
		List<Integer> sockPile = List.of(1,2,1,2,1,2,3);
		
		System.out.println(sockMerchant(sockPile.size(), new ArrayList<>(sockPile)));
	}

}
