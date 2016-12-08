package chap03.drill;

public class SelectSortApp {
	
	public static void main(String[] args) {
		
		SelectSort array = new SelectSort(100);
		
		for(int i = 0; i < 10; i++) {
			long value = (long) (Math.random() * 20);
			array.insert(value);
		}
		
		array.display();
		
		array.selectSort();
		array.display();
	}
}