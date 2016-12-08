package chap04.drill;

public class Queue {

	private long[] arrayQueue;
	private int front;
	private int rear;
	private int maxSize;
	private int elemN;
	
	public Queue(int max) {
		maxSize = max;
		arrayQueue = new long[maxSize];
		elemN = 0;
		front = 0;
		rear = -1;
	}
	
	public void insert(long value) {
		if(rear == maxSize - 1) {
			rear = -1;
		}
		arrayQueue[++rear] = value;
		elemN++;
	}
	
	public long get() {
		long temp = arrayQueue[front++];
		if(front == maxSize) {
			front = 0;
		}
		elemN--;
		return temp;
	}
	
	public long peek() {
		return arrayQueue[front];
	}
	
	public boolean isEmpty() {
		return (elemN == 0);
	}
	
	public boolean isFull() {
		return (elemN == maxSize);
	}
}