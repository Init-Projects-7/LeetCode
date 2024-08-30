package com.example.solutions.hackern;

public class Palindrome {
	
	   public static boolean isPalindrome(String s, int left, int right) {
	        while (left < right) {
	            if (s.charAt(left) != s.charAt(right)) {
	                return false;
	            }
	            left++;
	            right--;
	        }
	        return true;
	    }

	public static int palindromeIndex(String s) {
	      int left = 0;
	        int right = s.length() - 1;

	        while (left < right) {
	            if (s.charAt(left) != s.charAt(right)) {
	                if (isPalindrome(s, left + 1, right)) {
	                    return left;
	                }
	                if (isPalindrome(s, left, right - 1)) {
	                    return right;
	                }
	                return -1;
	            }
	            left++;
	            right--;
	        }
	        return -1;
	}
	
	
	public static boolean isPalindrome(String s) {
		StringBuilder strBuilder = new StringBuilder(s);
		return strBuilder.reverse().toString().equals(s);
	}
	public static void main(String[] args) {
		String a= "lhrxvssvxrhl";
		System.out.println(a);
		System.out.println(palindromeIndex(a));
		
	}
	
	

}
