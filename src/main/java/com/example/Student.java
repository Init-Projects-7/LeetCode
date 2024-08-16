package com.example;


class StudentException extends Exception{}

public class Student {
	
	public void eat() {
		System.out.println("Student is eating");
	}
	
	public static void m1() throws Exception{
		System.out.println("A");
		throw new StudentException();
	}
	
	public static void main(String[] args) {
		String java = "123456789";
		StringBuilder sb = new StringBuilder(java);
		sb.append(0).delete(0,2).deleteCharAt(5);
		java.substring(0, 7).substring(1,6).substring(2);
		System.out.println(java);
		System.out.println(sb);
	}

}



