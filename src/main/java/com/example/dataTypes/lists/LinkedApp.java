package com.example.dataTypes.lists;

public class LinkedApp {
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList(9);
		System.out.println(list.get(1));
		list.append(10);
		System.out.println(list.get(2));
		list.append(0);
		
		//list.printList();
	}

}
