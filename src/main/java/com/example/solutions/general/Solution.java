package com.example.solutions.general;
import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;


// https://www.hackerrank.com/contests/projecteuler/challenges/euler022/problem?isFullScreen=true
class ScoreD implements Callable<Integer>{

	public String name; 
	
	ScoreD(String name){		
		this.name = name;
	}
	
	@Override
	public Integer call() throws Exception {
		int score = 0;
		for (char ch: this.name.toUpperCase().toCharArray()) {
		     score += (int)ch - 64;  /* A is decimal 65 */
		}
		return score;
	}
	

}

public class Solution {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());   
        
        ExecutorService executor = Executors.newFixedThreadPool(10);
		Map<String, Future<Integer>> answerList = new HashMap<>();
		
        List<String> names = new ArrayList<String>();
        for(int a0 = 0; a0 < t; a0++){
        	//System.out.print("Add the value = ");
        	String name = in.nextLine();
        	names.add(name);
        	Future<Integer> answer = executor.submit(new ScoreD(name));
        	answerList.put(name, answer);        	
        }
        names = names.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        int findTheValue = Integer.parseInt(in.nextLine());  
        for(int a0 = 0; a0 < findTheValue; a0++){
        	//System.out.print("Query the name = ");
        	String queryName = in.nextLine();
        	Future<Integer> answer = answerList.get(queryName);
        	int counter = 1;
        	for(String name:names) {
        		if(name.equals(queryName)) {
        			System.out.println(answer.get()*counter);
        		}
        		counter++;
        	}
        	
        	
        }
        executor.shutdown();
        
    }

	    

}	