package com.example.solutions.hackern;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CaesarCipher {

	   public static String caesarCipher(String value, int k) {
		   return value.chars().mapToObj(c -> (char) replacement(c,k)).map(c->c.toString()).collect(Collectors.joining());
	   }
	   
	   public static int replacement(int x, int amount){
		   if(!belongs(x)) {
			   return x;
		   }
		   
		   if(x > 96) {
			   if(x + amount <= 122) {
				   return x+amount;
			   }
			   else {
				   return iterationPart(x+amount, 122);
			   }
		   }
		   else {
			   if(x + amount <= 90) {
				   return x+amount;
			   }
			   else {
				   return iterationPart(x+amount, 90);
			   }
		   }
			   
	   }
	   
	   public static int iterationPart(int currentVal, int upperBoundary) {
		   while(currentVal >upperBoundary) {
			   currentVal = currentVal - 26;
		   }		   
		   
		   return currentVal;
	   }
	   
	   public static boolean belongs(int x) {
		   if(x>=97 && x<=122) {
			   return true;
		   }else if(x>=65 && x<=90) {
			   return true;
		   }
		   else return false;
	   }
	   
	   public static void main(String[] args) {
		String secret = "www.abc.xy";
		int rotate = 87;
		System.out.println(caesarCipher(secret, rotate));
	}
}

