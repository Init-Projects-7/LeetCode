package com.example.solutions.leetcode.linked;

import java.util.HashMap;
import java.util.Map;

/**
* Add Two Numbers
* <a href="https://leetcode.com/problems/linked-list-cycle">Task Description</a> 
*  @author Sattar
*/	 



class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
        val = x;
   }
	
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

	
public class LinkedListCycle {
	
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		LinkedListCycle listCycle = new LinkedListCycle();
		System.out.println(listCycle.hasCycle(node));
	}

    public boolean hasCycle(ListNode head) {
        Map<Integer, ListNode> nodes = new HashMap<>();
    	while(head!=null) {
    		int hashCode = head.hashCode();
    		if(nodes.get(hashCode)!=null) {
    			return true;
    		}else {
    			nodes.put(hashCode, head);
    		}
    		head = head.next;
    	}
    	
    	return false;
    }
}
