package chap03.exper;

import chap03.drill.*;
import java.util.Date;

public class Exper02 {
	
	public static void main(String[] args) {
		
		BubbleSort bubble = new BubbleSort(100000);
		SelectSort select = new SelectSort(100000);
		InsertSort insert = new InsertSort(100000);
				
		for(int i = 0; i < 100000; i++) {
			// long value = (long) (Math.random() * 99999);
			bubble.insert(99999 - i);
		}
		
		for(int i = 0; i < 100000; i++) {
			// long value = (long) (Math.random() * 99999);
			select.insert(99999 - i);
		}
		
		for(int i = 0; i < 100000; i++) {
			// long value = (long) (Math.random() * 99999);
			insert.insert(99999 - i);
		}
		
		// bubble.display();		
		Date date1 = new Date();
		bubble.bubbleSort();
		Date date2 = new Date();		
		long msDelay = date2.getTime() - date1.getTime();
		// bubble.display();
		System.out.println("Bubble sort duration is " + msDelay + " in ms");
		
		// select.display();
		Date date3 = new Date();
		select.selectSort();
		Date date4 = new Date();
		msDelay = date4.getTime() - date3.getTime();
		// select.display();
		System.out.println("Seletion sort duration is " + msDelay + " in ms");
		
		// insert.display();
		Date date5 = new Date();
		insert.insertSort();
		Date date6 = new Date();
		msDelay = date6.getTime() - date5.getTime();
		// insert.display();
		System.out.println("Insertion sort duration is " + msDelay + " in ms");	
	}
}