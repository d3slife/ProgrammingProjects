package chap04.task41;

public class QueueApp {
	
	public static void main(String[] args) {
		
		int size = 6;
		Queue queue = new Queue(size);
		
		queue.insert(10);
		queue.insert(11);
		queue.insert(12);
		queue.insert(13);
		queue.insert(14);
		queue.insert(15);
		
		System.out.println(queue.delete());
		System.out.println(queue.delete());
		System.out.println(queue.delete());
		System.out.println("Items have been deleted");
		
		queue.insert(16);
		queue.insert(17);
		
		queue.showElements();
	}
}