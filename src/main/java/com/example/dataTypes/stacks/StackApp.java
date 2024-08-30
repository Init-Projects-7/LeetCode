package com.example.dataTypes.stacks;

public class StackApp {
	
	public static void main(String[] args) {
		Stack stack = new Stack(5);
		stack.push(3);
		stack.push(7);
		stack.printAll();
		stack.pop();
		stack.printAll();
	}

}
