package com.example.solutions.hackern;

public class DrawingBook {

    public static int pageCount(int amountPages, int neededPage) {
    	boolean backSide = false;
    	if(neededPage == 1 ) {
    		return 0;
    	}
    	boolean evenAmountPages = amountPages % 2 ==0 ? true : false;
    	if(evenAmountPages && amountPages - neededPage == 1) {
    		return 1;
    	}
    	if(!evenAmountPages && amountPages - neededPage == 1) {
    		return 0;
    	}
    	
    	
    	if(evenAmountPages) {
        	if(amountPages - neededPage < neededPage - 1) {
        		backSide = true;
        	}
    	}
    	else {
        	if(amountPages - 1 - neededPage < neededPage - 1) {
        		backSide = true;
        	}
    	}

    	int counter = 0;
    	System.out.println(backSide);
    	if(backSide) {
    		for(int i=amountPages-1; i>neededPage;i = i-2) {
    			counter++;
    		}
    	}
    	else {
    		for(int i=1; i< neededPage;i = i+2) {
    			counter++;
    		}
    	}
    	return counter;
    }
    
    public static void main(String[] args) {
		System.out.println(pageCount(2, 1));
	}
    
    
}
