package chap03.drill;

public class BubbleSortApp {
	
	public static void main(String[] args) {
		
		BubbleSort bubble = new BubbleSort(100);
	
		for(int i = 0; i < 7; i++) {
			long number = (long) (Math.random() * 10);
			bubble.insert(number);
		}
	
		bubble.display();
	
		bubble.bubbleSort();
		bubble.display();
	}	
}