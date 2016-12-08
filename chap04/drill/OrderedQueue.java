package chap04.drill;

public class OrderedQueue {
	
	private long[] ordQueue;
	private int maxSize;
	private int elemN;
	
	public OrderedQueue(int size) {
		maxSize = size;
		ordQueue = new long[maxSize];
	}
	
	public void insert(long value) {
		if(elemN == 0) {
			ordQueue[0] = value;
			elemN++;
		} else {
			int j;
			for(j = elemN - 1; j > 0; j--) {
				if(value > ordQueue[j]) {
					ordQueue[j + 1] = ordQueue[j];
				} else {
					break;
				}
			}
			ordQueue[j + 1] = value;
			elemN++;
		}
	}
	
	public long delete() {		
		return ordQueue[--elemN];
	}
	
	public long peek() {
		return ordQueue[elemN - 1];
	}
	
	public boolean isEmpty() {
		return (elemN == 0);
	}
	
	public boolean isFull() {
		return (elemN == maxSize);
	}
}