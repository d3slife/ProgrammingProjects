package chap04.drill;

public class StackArray {
	
	private long[] stack;
	private int maxSize;
	private int top;
	
	public StackArray(int max) {
		maxSize = max;
		stack = new long[maxSize];
		top = -1;
	}
	
	public void push(long value) {
		stack[++top] = value;
	}
	
	public long pop() {
		return stack[top--];
	}
	
	public long peek() {
		return stack[top];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return (top == maxSize - 1);
	}
}