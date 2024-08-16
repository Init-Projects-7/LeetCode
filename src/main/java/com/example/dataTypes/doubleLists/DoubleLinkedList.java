package com.example.dataTypes.doubleLists;


public class DoubleLinkedList {
	
    private Node head;
    private Node tail;
    private int length;
    
    
	
	public DoubleLinkedList(int val) {
		super();
		Node newNode = new Node(val);
	    head = newNode;
	    tail = newNode;
		this.length = 1;
	}

	public Node getHead() {
        return head;
    }
	
    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
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
        System.out.println("\nDoubly Linked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }
    
    public void append(int val) {
    	Node newNode = new Node(val);
    	if(this.length==0) {
    		head = newNode;
    		tail = newNode;
    	}else {    		
    		tail.next = newNode;
    		newNode.prev = tail;  
    		tail = newNode;
    	}
    	this.length++;
    }
    
    public Node removeLast() {
    	if(this.length == 0) return null;
    	if(this.length==1) {
    		Node temp = tail;
    		tail = null;
    		head = null;
    		this.length = 0;
    		return temp;
    	}else {   
    		Node temp = tail;
    		tail = tail.prev;
    		tail.next = null;
    		temp.prev = null;
    		this.length--;
    		return temp;
    	}    	
    }
    
    public void prepend(int val) {
    	Node newNode = new Node(val);
    	if(this.length==0) {
    		head = newNode;
    		tail = newNode;
    	}else {
    		Node tmp = head;
    		newNode.next = tmp;
    		head = newNode;    		
    	}
    	this.length++;
    }
    
    public Node removeFirst() {
    	if(this.length == 0) return null;
    	if(this.length==1) {
    		Node temp = head;
    		tail = null;
    		head = null;
    		this.length = 0;
    		return temp;
    	}else {   
    		Node temp = head;
    		head = head.next;
    		temp.next = null;
    		this.length--;
    		return temp;
    	}    	
    }
    

}
