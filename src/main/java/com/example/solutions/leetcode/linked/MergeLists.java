package com.example.solutions.leetcode.linked;



public class MergeLists {
	
	public static void main(String[] args) {
				
		ListNode list111 = new ListNode(111);
		ListNode list11 = new ListNode(11, list111);
		ListNode list1 = new ListNode(1, list11);		
		
		ListNode list222 = new ListNode(222);
		ListNode list22 = new ListNode(22,list222);
		ListNode list2 = new ListNode(2,list22);
		
		MergeLists merger = new MergeLists();
		ListNode header = merger.mergeTwoLists(list1, list2);
		merger.printList(header);
	}
	
    public void printList(ListNode head) {
    	ListNode temp = head;
        while (temp != null) {
        	System.out.println(temp.val);
        	temp = temp.next;            
        }
        System.out.println("------------------------------");
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
	    
	    if (list1 != null) {
	        head.next = list1;
	    } else {
	        head.next = list2;
	    }
    	return dummy.next;
        
    }
}
