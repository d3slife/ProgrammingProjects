package chap03.exper;

import chap03.drill.*;
import java.util.Date;

public class Exper01 {
	
	public static void main(String[] args) {
		
		BubbleSort bubble = new BubbleSort(10000);
		SelectSort select = new SelectSort(10000);
		InsertSort insert = new InsertSort(10000);
				
		for(int i = 0; i < 10000; i++) {
			long value = (long) (Math.random() * 9999);
			bubble.insert(value);
		}
		
		for(int i = 0; i < 10000; i++) {
			long value = (long) (Math.random() * 9999);
			select.insert(value);
		}
		
		for(int i = 0; i < 10000; i++) {
			long value = (long) (Math.random() * 9999);
			insert.insert(value);
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