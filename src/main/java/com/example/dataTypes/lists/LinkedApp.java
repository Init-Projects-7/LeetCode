package com.example.dataTypes.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.dataTypes.lists.LinkedList.Node;

public class LinkedApp {
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList(1);
		list.append(0);
		//list.append(0);
		
		list.append(6);
		list.append(4);
		list.append(7);
		list.append(0);
		list.append(7);
		list.append(2);
		list.append(4);

		//list.reverse();
		//list.printList();
		//System.out.println(list.findKthFromEnd(2,true).value);
		list.partitionList(3);
		//list.printList();
		list.append(0);
		
		list.printList();
		list.removeDuplicates();
		list.printList();
		list.reverseBetween(1, 3);
		list.printList();
		//System.out.println(list.findKthFromEnd(4).value);
		//System.out.println(list.findMiddleNode().value);	
		

		
	}

}
