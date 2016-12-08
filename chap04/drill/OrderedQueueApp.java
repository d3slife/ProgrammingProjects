package chap04.drill;

public class OrderedQueueApp {
	
	public static void main(String[] args) {
		
		int size = 10;
		OrderedQueue ordered = new OrderedQueue(size);
		
		ordered.insert(10);
		ordered.insert(3);
		ordered.insert(5);
		ordered.insert(8);
		ordered.insert(1);
		
		System.out.println(ordered.delete());
		System.out.println(ordered.delete());
		System.out.println(ordered.delete());
		System.out.println(ordered.delete());
		System.out.println(ordered.delete());
	}
}