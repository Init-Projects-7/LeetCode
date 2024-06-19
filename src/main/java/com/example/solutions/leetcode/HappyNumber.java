package com.example.solutions.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Remove Duplicates
 * <a href="https://leetcode.com/problems/happy-number/description/?envType=study-plan-v2&envId=top-interview-150">Task Description</a> 
 * @author Sattar
 *
 */
public class HappyNumber {
	
	public static void main(String[] args) {
		System.out.println(isHappy(100));
		System.out.println(isHappy(5));
	}
	
    public static boolean isHappy(int n) {
        Set<Integer> seenNumbers = new HashSet<>();
        while (n != 1 && !seenNumbers.contains(n)) {
            seenNumbers.add(n);
            n = sumOfSquaresOfDigits(n);
        }
        return n == 1;
    }

    private static int sumOfSquaresOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

}
