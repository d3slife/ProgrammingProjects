package chap04.task41;

public class Queue {
	
	private long[] arrayQueue;
	private int maxSize;
	private int elemN;
	private int front;
	private int rear;
	
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
		rear++;
		arrayQueue[rear] = value;
		elemN++;
	}
	
	public long delete() {
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
	
	public int getSize() {
		return elemN;
	}
	
	// Task 4.1
	public void showElements() {
		int i = front;
		int j = 0;
		while(j < elemN) {
			if(i == maxSize) {
				i = 0;
			}
			long value = arrayQueue[i];
			System.out.println(value);
			j++;
			i++;			
		}
	}
	
}