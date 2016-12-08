package chap02;

public class OrdArray3App {

	public static void main(String[] args) {
		
		OrdArray3 array = new OrdArray3(100);
		
		array.insert(10);
		array.insert(20);
		array.insert(-3);
		array.insert(-5);
		array.insert(22);
		array.insert(100);
		array.insert(-100);
		array.insert(0);
		array.insert(1);
		
		array.display();
	}
}