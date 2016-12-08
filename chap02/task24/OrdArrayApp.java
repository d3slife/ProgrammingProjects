package chap02.task24;

public class OrdArrayApp {

	public static void main(String[] args) {
		
		OrdArray array = new OrdArray(100);
		
		array.insert(10);
		array.insert(5);
		array.insert(11);
		array.insert(2);
		array.insert(20);
		array.insert(2);
		array.insert(11);
		array.insert(-5);
		
		array.display();
		
		int index = array.find(20);
		System.out.println(index);
		
		array.delete(11);
		
		array.display();
		
		index = array.find(20);
		System.out.println(index);
	}
}