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
    
    public Node get(int index){
    	if(length == 0) return null;
        if(index < 0 || index > length) return null;
        if (index == 0 ) return head;
        Node temp = head;
        int counter = 0;
        while(temp!=null) {
        	if(counter == index) {
        		return temp;
        	}else {
        		counter++;
        		temp = temp.next;
        	}
        }
        return null;
    }
    
    public boolean set(int index, int value){
    	if(length == 0) return false;
        if(index < 0 || index > length) return false;
        if (index == 0 ) {
        	head.value = value;
        	return true;
        }
        if(index == this.length) {
        	tail.value = value;
        	return true;
        }
        Node currNode = this.get(index);
        currNode.value = value;
        return true;
    }
    
    public boolean insert(int index, int value) {
        if(index < 0 || index > length) return false;
        if(index == length) { this.append(value); return true;}
        if(index == 0) {this.prepend(value); return true;}
        Node prevNode = this.get(index - 1);
        Node selectedIndex = this.get(index);
        Node newNode = new Node(value);
        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = selectedIndex;
        selectedIndex.prev = newNode;
        this.length++;
    	return true;
    }
    
    
    public Node remove(int index) {
        if(index < 0 || index > length-1) return null;
        if(index == length-1) return this.removeLast();
        if(index == 0) return this.removeFirst();
        Node nextNode = this.get(index + 1);
        Node removableNode = this.get(index);
        Node prevNode = this.get(index - 1);
        nextNode.prev = prevNode;
        prevNode.next = nextNode;
        this.length--;
    	return removableNode;
    }
    
    public void swapFirstLast() {
    	if(length == 0) return;
    	if(length == 1) return;
       else{
    		int val = head.value;
    		head.value = tail.value;
    		tail.value = val;
    		
    	}
    }
    
    public void reverse() {
        Node current = head;
        Node temp = null;
    
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
    
        temp = head;
        head = tail;
        tail = temp;
    }
    
    
    public boolean isPalindrome() {
    	Node refHead = head;
    	Node refTail = tail;
    	
    	while(refHead!=null && refTail!=null) {
    		if(refHead.value != refTail.value) {
    			return false;
    		}else {
    			refHead = refHead.next;
    			refTail = refTail.prev;
    		}
    	}
    	return true;
    }

}
