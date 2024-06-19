package com.example.solutions.leetcode;


/**
 * Gas Station
 * <a href="https://leetcode.com/problems/gas-station/description/?envType=study-plan-v2&envId=top-interview-150">Task Description</a> 
 * @author Sattar
 *
 */


public class GasStation {

	public static void main(String[] args) {
		GasStation gasStationTask = new GasStation();
		int[] gas = {2,3,4};
		int[] cost = {3,4,3};
		System.out.println(gasStationTask.canCompleteCircuit(gas, cost));
		
	}
	
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return totalGas >= totalCost ? start : -1;
    }
    

}
