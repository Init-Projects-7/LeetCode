package com.example.dataTypes.stacks;


public class Stack {
	
    private Node top;
    private int height;
    
    public Stack(int val) {
		super();
		Node newNode = new Node(val);
		this.top = newNode;
		this.height = 1;
		
	}
    
    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Node getTop() {
        return top;
    }

    public int getHeight() {
        return height;
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (height == 0) {
            System.out.println("Top: null");
        } else {
            System.out.println("Top: " + top.value);
        }
        System.out.println("Height:" + height);
        System.out.println("\nStack:");
        if (height == 0) {
            System.out.println("empty");
        } else {
            printStack();
        }
    }
    
    public void makeEmpty() {
        top = null;
        height = 0;
    }
    
    public void push(int val){
    	Node node = new Node(val);
    	if(height==0) {
    		top = node;
    		height++;
    	}
    	else {
    		Node tmp = top;
    		node.next = tmp;
    		top = node;
    		height++;
    	}  	
    }
    
    public Node pop() {
    	if(height == 0) return null;
    	if(height == 1) { 
    		Node tmp = top; 
    		top = null;
    		height--;
    		return tmp;
    	}
		Node tmp = top; 
		top = top.next;
		height--;
		return tmp;
    }
    
}

