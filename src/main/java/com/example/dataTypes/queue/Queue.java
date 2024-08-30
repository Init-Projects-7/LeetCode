package com.example.dataTypes.queue;



public class Queue {


    private Node first;
    private Node last;
    private int length;
    
    public Queue(int val) {
		super();
		Node newNode = new Node(val);
		this.first = newNode;
		this.last = newNode;
		this.length = 1;
		
	}
    
    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("First: null");
            System.out.println("Last: null");
        } else {
            System.out.println("First: " + first.value);
            System.out.println("Last: " + last.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nQueue:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }
    
    public void makeEmpty() {
        first = null;
        last = null;
        length = 0;
    }
    
    public void enqueue(int val) {
    	Node newNode = new Node(val);
    	if(length==0) {
    		this.first = newNode;
    		this.last = newNode;
    		length++;
    	}
    	else {
    		this.last.next = newNode;
    		this.last = newNode;
    		length++;    		
    	}    	
    }
    
    
    public Node dequeue() {
    	if(length == 0) return null;
    	if(length == 1) {
    		Node tmp = first;
    		first = null;
    		last = null;
    		length--;
    		return tmp;
    	}else {
    		Node tmp = first;
    		first = first.next;
    		length--;
    		return tmp;
    	}
    }

}
