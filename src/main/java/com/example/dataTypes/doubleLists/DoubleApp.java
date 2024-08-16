package com.example.dataTypes.doubleLists;

public class DoubleApp {
	
	public static void main(String[] args) {
		DoubleLinkedList doubleLinked = new DoubleLinkedList(7);
		doubleLinked.append(1);
		doubleLinked.append(4);
		doubleLinked.append(2);
		doubleLinked.append(8);
		//doubleLinked.printAll();
		doubleLinked.prepend(10);
		doubleLinked.printAll();
		doubleLinked.removeFirst();
		doubleLinked.printAll();
	}
	
	

}
