package chap04.task42;

public class DequeueApp {
	
	public static void main(String[] args) {
		
		int size = 6;
		Dequeue dequeue = new Dequeue(size);
	
		dequeue.insertRight(10);
		dequeue.insertLeft(9);
		dequeue.insertRight(11);
		dequeue.insertLeft(8);
	
		while(!dequeue.isEmpty()) {
			long temp = dequeue.removeLeft();
			System.out.println(temp);
		}	
	}	
}