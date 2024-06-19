package com.example.solutions.hackern;

import java.util.ArrayList;
import java.util.List;

public class BreakingBestWorst {	
	
	

    public static List<Integer> breakingRecords(List<Integer> scores) {
    	Integer goodAmount = 0;
    	Integer bestScoreValue = scores.get(0);
    	Integer badAmount = 0;
    	Integer worstScoreValue = scores.get(0);
    	List<Integer> answerList = new ArrayList<>();   
    	for(int i = 1; i<scores.size();i++) {
    		if(scores.get(i) > bestScoreValue) {
    			goodAmount++;
    			bestScoreValue = scores.get(i);
    		}
    		else if(scores.get(i) < worstScoreValue) {
    			badAmount++;
    			worstScoreValue = scores.get(i);
    		}
    	}
    	answerList.add(goodAmount);
    	answerList.add(badAmount);
    	return answerList;

    }
    
    public static void main(String[] args) {
		List<Integer> arr= List.of(3, 4, 21, 36, 10, 28, 35, 5, 24, 42);
		System.out.println(breakingRecords(new ArrayList<>(arr)));
		
	}


}
