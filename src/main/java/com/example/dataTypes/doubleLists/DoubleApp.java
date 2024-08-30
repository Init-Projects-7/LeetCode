package com.example.dataTypes.doubleLists;

public class DoubleApp {
	
	public static void main(String[] args) {
		DoubleLinkedList doubleLinked = new DoubleLinkedList(0);
		doubleLinked.append(1);
		doubleLinked.append(2);
		doubleLinked.append(3);
		doubleLinked.append(4);
		//doubleLinked.printAll();
		//doubleLinked.prepend(10);
		doubleLinked.printAll();
		doubleLinked.reverse();
		System.out.println("--------------------");
		doubleLinked.printAll();
	}
	
	

}
