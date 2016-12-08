package chap03.drill;

public class InsertSortApp {
	
	public static void main(String[] args) {
		
		InsertSort array = new InsertSort(100);
		
		for(int i = 0; i < 5; i++) {
			long value = (long) (Math.random() * 10);
			array.insert(value);
		}
		
		array.display();
		
		array.insertSort();
		array.display();
	}
}