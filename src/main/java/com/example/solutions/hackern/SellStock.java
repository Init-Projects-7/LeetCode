package com.example.solutions.hackern;

public class SellStock {
	
    public static int maxProfit(int[] prices) {
    	boolean bought = false;
    	int profit = 0;
    	if(prices.length == 2) {
    		if(prices[0] < prices[1]) {
    			return prices[1] - prices[0];
    		}
    		else {
    			return 0;
    		}
    	}
    	for(int i=0; i<prices.length-1;i++) {
    		if(bought) {
    			if(prices[i] < prices[i+1] && i+1 == prices.length-1) {
    				profit = profit + prices[i+1];
    				break;
    			}else if(prices[i] > prices[i+1]) {
    				profit = profit + prices[i];
    			}else {
    				continue;
    			}
    			bought = false;
    		}else {
    			if(prices[i] < prices[i+1] && i+1==prices.length-1) {
    				profit = profit - prices[i] + prices[i+1];
    				break;
    			}
    			if(prices[i] < prices[i+1]) {
    				profit = profit - prices[i];
    			}else {
    				continue;
    			}
    			bought = true;
    		}
    		
    	}
        return profit;
    }

	public static void main(String[] args) {
		int[] days = {2,1,4};
		System.out.println(maxProfit(days));
	}
}
