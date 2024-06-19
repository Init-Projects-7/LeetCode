package com.example.solutions.leetcode;

public class ValidPalindrome {
	
	public static void main(String[] args) {
		ValidPalindrome validPal = new ValidPalindrome();
		String s = "A man, a plan, a canal: Panama";
		System.out.println(validPal.isPalindrome(s));
	}
    public boolean isPalindrome(String s) {
    	String oldString = s.trim().toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        StringBuilder builder = new StringBuilder(oldString);
        if(builder.reverse().toString().equals(oldString))return true;
        return false;
    }
}
