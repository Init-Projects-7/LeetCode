package com.example.solutions.hackern;

import java.util.Arrays;

public class RecursiveDigitSum {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */

    public static int superDigit(String str, int n) {
    	if(isPowerOfTen(n)) {
    		n = 1;
    	}
        int sum = str.chars()
                .map(Character::getNumericValue)
                .sum();
        sum *= n;
        return superDigit(String.valueOf(sum));
    }

    public static int superDigit(String str) {
        int sum = str.chars()
                .map(Character::getNumericValue)
                .sum();
        if (sum >= 10) {
            return superDigit(String.valueOf(sum));
        }
        return sum;
    }
    
    public static boolean isPowerOfTen(int number) {
        if (number <= 0) {
            return false;
        }

        while (number % 10 == 0) {
            number /= 10;
        }

        return number == 1;
    }
    
    public static void main(String[] args) {
    	System.out.println(superDigit("9875",100));
	}
}
