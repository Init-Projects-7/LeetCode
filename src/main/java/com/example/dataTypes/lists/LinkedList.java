package com.example.dataTypes.lists;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println("----------------------------");
    }
    
    public static void printList(Node temp) {
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println("----------------------------");
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }
    
    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) return null;
        Node temp = head;
        Node pre = head;
        while(temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node get(int index){
    	if(length == 0) return null;
    	if(index >= length) return null;
    	if(index < 0) return null;
    	Node temp = head;
    	if(length == 1 && index == 0) return head;
    	int counter = 0;
    	while(counter < index) {
    		if(counter + 1  == index) {
    			return temp.next;
    		}else {
    			counter++;
    			temp = temp.next;
    		}
    	}
    	return temp;
    }
    
    public boolean set(int index, int value){
    	if(this.get(0)==null) return false;
    	if(index >= length) return false;
    	if(index == 0) {
    		head.value = value;
    		return true;
    	}
    	Node temp = head;
    	int counter = 0;
    	while(counter != index + 1) {
    		if(counter == index) {
    			temp.value = value;
    			return true;
    		}else {
    			counter++;
    			temp = temp.next;
    		}
    	}
    	return true;
    }
    
    public boolean insert(int index, int value){
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }
    
    
    public Node remove(int index){
    	if (length == 0) return null;
    	if (index == 0) return removeFirst();
    	if (index == this.length -1) return removeLast();
    	if (index >= length || index < 0) return null;
    	
    	Node prev = get(index - 1);
    	Node curr = get(index);
    	Node next = get(index + 1);
    	prev.next = next;
    	this.length--;
    	return curr;
    }
    
    public void reverse() {
    	Node temp = head;
    	head = tail;
    	tail = temp;
    	Node after = temp.next;
    	Node before = null;
		
    	for(int i = 0;i <this.length;i++) {
    		after = temp.next;
    		temp.next = before;
    		before = temp;
    		temp = after;
    	}
    }
    
    public Node findMiddleNode() {
    	int length = 0;    	
    	Node temp = head;
    	Node findMiddlePos = head;
    	while(temp!=null) {
    		temp = temp.next;
    		length++;
    	}
    	
    	if(length==0) return null;
    	if(length==1) return head;
    	if(length==2) return head; 
    	int middlePosition = length / 2;
    	for(int i = 0;i <middlePosition;i++) {
    		findMiddlePos = findMiddlePos.next;
    	}
    	return findMiddlePos;
    } 
    
    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;
 
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
 
            if (slow == fast) {
                return true;
            }
        }
 
        return false;
    	
    }
    
    
    public Node findKthFromEnd(int k) {
        if(k == 1) {
        	return tail;
        }
    	
        Node slow = head;
        int slowInt = 1;
        Node fast = head;
        int fastInt = 1;
 
        while (fast != null && fast.next != null) {
            slow = slow.next;            
            fast = fast.next.next;
            
            slowInt++;
            fastInt = fastInt + 2;
            if(fast==null) {
            	fastInt--;
            }
        }
        
//        System.out.println(fastInt+ " / " + slowInt +  " / "+ k );
        if(fastInt < k) {
        	return null;
        }
        
        if(fastInt == k) {
        	return head;
        }
        
        if(fastInt - k == 1) {
        	return head.next;
        }
        
        if(fastInt - k + 1 == slowInt) {
        	return slow;
        }
        
        while(slowInt < fastInt - k + 1) {
        	 slow = slow.next;  
        	 slowInt++;
        }
        
        return slow;
    }
    
    
    public Node findKthFromEnd(int k, boolean b) {
        Node slow = head;
        Node fast = head;
 
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
 
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
 
        return slow;
    }
    
    public void partitionList(int x) {
    	if(head == null) return;
        Node trav = head;
        
        
        Node smaller = new Node(0);
        Node greater = new Node(0);
        Node prevSmaller = smaller;
        Node prevGreater = greater;
        
        while (trav != null) {
            if (trav.value < x) {
            	prevSmaller.next = trav;
            	prevSmaller = trav;
            } else {
            	prevGreater.next = trav;
            	prevGreater = trav;
            }
            trav = trav.next;
        }
        prevGreater.next = null;
        prevSmaller.next = greater.next;
        head = smaller.next;
    }
    
    public void removeDuplicates() {
    	if(head == null) return;
    	if(head.next == null) return;
    	Node trav = head;
    	Node afterTrav = head.next;
    	Set<Integer> mySet = new HashSet<Integer>();
    	mySet.add(trav.value);
        while (trav != null && afterTrav != null) {
        	if(mySet.contains(afterTrav.value)) {
        		Node tmp = afterTrav.next;
        		trav.next = tmp;
        		afterTrav = trav.next;
        	}
        	else {
        		mySet.add(afterTrav.value);
            	trav = trav.next;
            	afterTrav = afterTrav.next;
        	}

        }
    }
    
    public void reverseBetween(int m, int n) {
    	if(head == null) return;
    	if(head.next == null) return;    	

    	Node trav = head;
    	Node start = null;
    	Node end = null;
    	int counter = 0;
    	
        while (trav != null) {
        	if(counter==m) {
        		start = trav;
        	}
        	
        	if(counter==n) {
        		end = trav;
        		trav.value = start.value;
        		start.value = end.value;
        		
        	}
        	
        	trav = trav.next;
        	counter++;        
        }
    }
    
    public int binaryToDecimal() {
    	int sum = 0;
    	int counter = this.length;
    	Node temp = head;
    	while(temp!=null) {
    		sum += temp.value + counter * 2;
    		temp = temp.next;
    		counter--;
    	}
    	return sum;
    }
    
}

