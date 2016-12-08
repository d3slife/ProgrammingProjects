package chap03.task35;

public class InsertSortApp {
	
	public static void main(String[] args) {
		
		int max = 10;
		InsertSort array = new InsertSort(max);
				
		for(int i = 0; i < max; i++) {
			long value = (long) (Math.random() * max);
			array.insert(value);
		}
							
		array.display();
		array.insertSort2();
		array.display();
	}
}