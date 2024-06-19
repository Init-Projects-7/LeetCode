package com.example.solutions.leetcode.linked;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReversedList {
	
	public void printList(ListNode head) {
	  ListNode temp = head;
	    while (temp != null) {
	            System.out.println(temp.val);
	            temp = temp.next;
	   }
	}
	    
	   
    public ListNode reverseList(ListNode head) {
    	if(head == null) return head;
    	List<Integer> values = new ArrayList<>();

        while(head!=null) {
        	values.add(head.val);
        	head = head.next;

        }
        
        values = values.stream().collect(Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    Collections.reverse(list);
                    return list;
                }
            ));
        ListNode newHead = new ListNode(values.get(0));
        ListNode temp = newHead;
        for(int i = 1; i< values.size();i++) {
        	temp.next = new ListNode(values.get(i));
        	temp = temp.next;        	
        }
        return newHead;
    }
    
    public static void main(String[] args) {
    	ListNode fourthChild = new ListNode(5);
    	ListNode thirdChild = new ListNode(4,fourthChild);
    	ListNode secondChild = new ListNode(3, thirdChild);
    	ListNode firstChild =  new ListNode(2, secondChild);
		ListNode head = new ListNode(1, firstChild);
		ReversedList reverse = new ReversedList();
		head = reverse.reverseList(head);
		reverse.printList(head);
		
	}
}
