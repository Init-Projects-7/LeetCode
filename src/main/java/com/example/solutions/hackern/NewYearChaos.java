package com.example.solutions.hackern;

import java.util.List;


public class NewYearChaos {

    public static void minimumBribes(List<Integer> q) {
        int bribeAmount = 0;

        for (int i = q.size() - 1; i >= 0; i--) {
            // Check if the person is more than 2 positions ahead
            if (q.get(i) - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(0, q.get(i) - 2); j < i; j++) {
                if (q.get(j) > q.get(i)) {
                    bribeAmount++;
                }
            }
        }

        System.out.println(bribeAmount);
    }
    
    public static void main(String[] args) {
    	List<Integer> sorted = List.of(1,2,5,3,7,8,6,4);
    	minimumBribes(sorted);
	}
}
