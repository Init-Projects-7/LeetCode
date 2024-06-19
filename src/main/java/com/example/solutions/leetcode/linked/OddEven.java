package com.example.solutions.leetcode.linked;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/odd-even-linked-list
 * @author aqccj
 *
 */
public class OddEven {
	
    public void printList(ListNode head) {
    	ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    
    
    public ListNode oddEvenList(ListNode head) {
    	if(head == null) return head;
    	List<Integer> oddNodes = new ArrayList<>();
    	List<Integer> evenNodes = new ArrayList<>();
    	int counter = 1;
        while(head!=null) {
        	if(counter % 2 == 0) {
        		evenNodes.add(head.val);
        	}
        	else {
        		oddNodes.add(head.val);
        	}
        	head = head.next;
        	counter++;
        }
        evenNodes.forEach(x -> oddNodes.add(x));
        ListNode newHead = new ListNode(oddNodes.get(0));
        ListNode temp = newHead;
        for(int i = 1; i< oddNodes.size();i++) {
        	temp.next = new ListNode(oddNodes.get(i));
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
		OddEven oddEven = new OddEven();
		head = oddEven.oddEvenList(head);
		oddEven.printList(head);
		
	}
}
