package com.example.solutions.leetcode;

import java.util.Arrays;

/**
 * Add Two Numbers
 * <a href="https://leetcode.com/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-interview-150">Task Description</a> 
 * @author Sattar
 *
 */
 
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
public class AddTwoNumbers {
	
	public static void main(String[] args) {
		
		
		ListNode l13 = new ListNode(3);
		ListNode l12 = new ListNode(4,l13);
		ListNode l11 = new ListNode(2,l12);
		
		ListNode l23 = new ListNode(4);
		ListNode l22 = new ListNode(6,l23);
		ListNode l21 = new ListNode(5,l22);
		
		ListNode sumNode = addTwoNumbers(l11,l21);
		
        while(sumNode!=null) {
        	System.out.println(sumNode.val);
        	sumNode = sumNode.next;
        }
	}
	
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	 ListNode dummyHead = new ListNode(); // Dummy head to simplify the logic
         ListNode current = dummyHead;
         int carry = 0;

         while (l1 != null || l2 != null) {
             int x = (l1 != null) ? l1.val : 0;
             int y = (l2 != null) ? l2.val : 0;

             int sum = x + y + carry;
             carry = sum / 10;

             current.next = new ListNode(sum % 10);
             current = current.next;

             if (l1 != null) l1 = l1.next;
             if (l2 != null) l2 = l2.next;
         }

         if (carry > 0) {
             current.next = new ListNode(carry);
         }

         return dummyHead.next;        
    }
    
}

