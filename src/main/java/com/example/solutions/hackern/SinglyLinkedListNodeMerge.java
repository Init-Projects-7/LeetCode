package com.example.solutions.hackern;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SinglyLinkedListNodeMerge {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep){
        while (node != null) {
            System.out.println(node.data);
            node = node.next;

            if (node != null) {
                System.out.println(sep);
            }
        }
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    	if (head1 == null) return head2; 
        if (head2 == null) return head1;
        SinglyLinkedListNode result = null;
        
 		if(head1.data > head2.data) {    		
    		result = head2;
			head2 = head2.next;
		}else {    		
    		result = head1;
			head1 = head1.next;
		}
 		
 		SinglyLinkedListNode current = result;
    	
        while(head1!=null || head2!=null) {
        	if(head1==null) {
        		current.next = head2;
        		head2 = head2.next;
        	}
        	else if(head2==null) {
        		current.next = head1;
        		head1 = head1.next;
        	}
        	else {
        		if(head1.data > head2.data) {
            		current.next = head2;
            		head2 = head2.next;
        		}else {
            		current.next = head1;
            		head1 = head1.next;
        		}
        	}
        	current = current.next;
        }
        return result;
    }

 

    public static void main(String[] args) throws IOException {


            SinglyLinkedList llist1 = new SinglyLinkedList();      
            llist1.insertNode(1);
            llist1.insertNode(3);
            llist1.insertNode(7);
          	SinglyLinkedList llist2 = new SinglyLinkedList();
            llist2.insertNode(1);
            llist2.insertNode(2);
            SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);
            printSinglyLinkedList(llist3, " " );

    }
}
