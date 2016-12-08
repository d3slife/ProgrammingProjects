package chap03.task36;

public class InsertSortApp {
	
	public static void main(String[] args) {
		
		int max = 30;
		InsertSort array = new InsertSort(max);
				
		for(int i = 0; i < max; i++) {
			long value = (long) (Math.random() * 5);
			array.insert(value);
		}
							
		array.display();
		array.insertNumber();
		array.display();
	}
}