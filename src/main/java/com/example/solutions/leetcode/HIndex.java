package com.example.solutions.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * url: https://leetcode.com/problems/h-index/?envType=study-plan-v2&envId=top-interview-150
 * @author aqccj
 *
 */
public class HIndex {

    public int hIndex(int[] citations) {
    	Arrays.stream(citations).forEach(x -> System.out.print(x+" / "));
    	System.out.println("------------------");
    	citations = Arrays.stream(citations).sorted().toArray();
    	Arrays.stream(citations).forEach(x -> System.out.print(x+" / "));
    	System.out.println("------------------");
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int hIndex = n - i; // Number of papers with at least hIndex citations
            if (citations[i] >= hIndex) {
                return hIndex;
            }
        }
        
        return 0;
        
    }
    
    public static void main(String[] args) {
		int[] arr = {3,0,6,1,5};
		HIndex calculate = new HIndex();
		System.out.println(calculate.hIndex(arr));
	}
    
    
}
