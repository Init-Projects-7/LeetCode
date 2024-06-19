package com.example.solutions.general;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringReverse {

	public static void main(String[] args) {
		String str = new String("Hello World");
		StringBuilder sb = new StringBuilder(str);
		String reversed =reverseString(str);
		str = sb.reverse().toString();
		System.out.println(sb.reverse());
		System.out.println(str);
	}
	
    public static String reverseString(String str) {
        return IntStream.range(0, str.length())
                        .mapToObj(i -> str.charAt(str.length() - 1 - i))
                        .map(String::valueOf)
                        .collect(Collectors.joining());
    }
}
