package chap04.drill;

public class StackArrayChar {
	
	private char[] stack;
	private int maxSize;
	private int top;
	
	public StackArrayChar(int max) {
		maxSize = max;
		stack = new char[maxSize];
		top = -1;
	}
	
	public void push(char value) {
		stack[++top] = value;
	}
	
	public char pop() {
		return stack[top--];
	}
	
	public char peek() {
		return stack[top];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return (top == maxSize - 1);
	}
}