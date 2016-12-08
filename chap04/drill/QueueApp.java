package chap04.drill;

public class QueueApp {
	
	public static void main(String[] args) {
		
		Queue queue = new Queue(5);
		queue.insert(10);
		queue.insert(20);
		queue.insert(30);
		queue.insert(40);
		
		// System.out.println(queue.get());
		// System.out.println(queue.get());
		// System.out.println(queue.get());
		
		queue.get();
		queue.get();
		queue.get();
		
		queue.insert(50);
		queue.insert(60);
		queue.insert(70);
		queue.insert(80);
		
		System.out.println(queue.get());
		System.out.println(queue.get());
		System.out.println(queue.get());
		System.out.println(queue.get());
		System.out.println(queue.get());
	}
}