package chap02;

public class Chap02Task01App {

	public static void main(String[] args) {
		
		int max = 100;
		Chap02Task01 array = new Chap02Task01(max);
		
		array.insert(20);
		array.insert(19);
		array.insert(2);
		array.insert(5);
		array.insert(10);
		array.insert(7);
		array.insert(44);
		array.insert(33);
		array.insert(1);
		array.insert(0);
		
		// Project 2.3
		int quantity = array.size();
		Chap02Task01 array2 = new Chap02Task01(quantity);
		for(int i = 0; i < quantity; i++) {
			long temp = array.removeMax();
			array2.insert(temp);
		}
		array2.display();
		// The end of project 2.3
		
		array.display();
		
		int index = array.find(0);
		System.out.println(index);
		
		array.delete(20);
		array.delete(0);
		array.delete(88);
		
		array.display();

		long maxValue = array.getMax();
		System.out.println(maxValue);
		
		array.removeMax();
		
		array.display();
		
		
	}
}