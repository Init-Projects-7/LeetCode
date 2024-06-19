package com.example.solutions.leetcode.linked;


/**
 * Link: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/?envType=study-plan-v2&envId=leetcode-75
 * @author aqccj
 *
 */
public class DeleteMiddle {
	
    public void printList(ListNode head) {
    	ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
	
    public ListNode deleteMiddle(ListNode head) {
       ListNode temp = head;
       ListNode prev = head;
       if(head.next==null) {
    	   return null;
       }
       int counter = 0;
       while(temp!=null) {
    	   counter++;
    	   temp = temp.next;
       }
       temp = head;
       prev = temp;
       int middle = counter / 2;
       while(middle!=0) {
    	   prev = temp;
    	   temp = temp.next;
    	   middle--;
       }      
       prev.next = temp.next;
       return head;
    }
    
    public static void main(String[] args) {
//    	ListNode fourthChild = new ListNode(5);
//    	ListNode thirdChild = new ListNode(4,fourthChild);
    	//ListNode secondChild = new ListNode(3);
    	ListNode firstChild =  new ListNode(2);
		ListNode head = new ListNode(0);
		DeleteMiddle deleteMiddle = new DeleteMiddle();
		head = deleteMiddle.deleteMiddle(head);
		deleteMiddle.printList(head);
		
	}
}
