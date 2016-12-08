package chap02.task25;

public class OrdArrayApp {

	public static void main(String[] args) {
		
		OrdArray array1 = new OrdArray(100);
		OrdArray array2 = new OrdArray(100);
		
		for(int i = 0; i < 5; i++) {
			long value = (long) (Math.random() * 100);
			array1.insert(value);
		}
		
		for(int i = 0; i < 3; i++) {
			long value = (long) (Math.random() * 100);
			array2.insert(value);
		}
		
		array1.display();
		array2.display();
		
		OrdArray array3 = new OrdArray(100);
		array3 = array1.merge(array1, array2);
		array3.display();
	}
}