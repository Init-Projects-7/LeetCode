package com.example.solutions.leetcode;

/**
 * Jump Game
 * <a href="https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150">Task Description</a> 
 * @author Sattar
 *
 */
public class JumpGame {


	public static void main(String[] args) {
		JumpGame jumper = new JumpGame();
		int[] nums = {2,3,1,1,4};
		//System.out.println(jumper.canJump(nums));
		System.out.println(jumper.canJump(nums,false));
	}
	
	public boolean canJump(int[] nums) {
		int position = 0;
		if(nums.length==1) {
			return true;
		}
		while(position<nums.length) {			
			int nextIndex = nums[position];
			System.out.println(position+" / "+nextIndex);
			if((nextIndex==0 || nextIndex==1) && nums.length==1) {
				return true;
			}
			if(nextIndex==0) {
				return false;
			}
			position = position + nextIndex;
			if(position >= nums.length-1) {
				return true;
			}
		}
		return false;
	}
	
    public boolean canJump(int[] nums, boolean b) {
        int reachable = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
            System.out.println(reachable+" / "+i);
        } 
        return true;
     }
}
