package chap03.task34;

public class InsertSortApp {
	
	public static void main(String[] args) {
		
		int max = 25;
		InsertSort array = new InsertSort(max);
		
		for(int i = 0; i < max; i++) {
			long value = (long) (Math.random() * max);
			array.insert(value);
		}
		
		array.display();
		array.oddEvenSort();
		array.display();
	}
}