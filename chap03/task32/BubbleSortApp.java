package chap03.task32;

import java.util.Date;

public class BubbleSortApp {
	
	public static void main(String[] args) {
		
		int max = 100000;
		
		BubbleSort bubble = new BubbleSort(max);
		BubbleSort bubble2 = new BubbleSort(max);
	
		for(int i = 0; i < max; i++) {
			long number = (long) (Math.random() * max);
			bubble.insert(number);
			bubble2.insert(number);
		}	
		// bubble.display();
		
		// One-directional bubble sort with time measurement;
		Date date1 = new Date();
		bubble.bubbleSort();
		Date date2 = new Date();
		long msDelay = date2.getTime() - date1.getTime();
		// bubble.display();		
		System.out.println("One-directional bubble sort duration is " + msDelay + " in ms");
		
		// Task 3.1;
		//Be-directional bubble sort with time measurement;
		Date date3 = new Date();
		bubble2.bubbleSort();
		Date date4 = new Date();
		msDelay = date4.getTime() - date3.getTime();
		// bubble2.display();
		System.out.println("Bi-directional bubble sort duration is " + msDelay + " in ms");
		
		// Task 3.2;
		BubbleSort bubble3 = new BubbleSort(max);
		max = 10000;
		
		for(int i = 0; i < max; i++) {
			long value = (long) (Math.random() * max);
			bubble3.insert(value);
		}
		
		System.out.println(bubble3.median());
	}	
}