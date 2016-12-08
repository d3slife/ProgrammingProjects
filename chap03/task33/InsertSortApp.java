package chap03.task33;

public class InsertSortApp {
	
	public static void main(String[] args) {
		
		InsertSort array = new InsertSort(100);
		
		
		for(int i = 0; i < 20; i++) {
			long value = (long) (Math.random() * 5);
			array.insert(value);
		}
		array.display();
		
		array.insertSort();
		array.display();
		
		array.noDups();
		array.display();
	}
}