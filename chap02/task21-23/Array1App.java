package chap02;

class Array1App {
	
	public static void main(String[] args) {
		int max = 100;
		Array1 array = new Array1(100);
		
		array.insert(10);
		array.insert(20);
		array.insert(8);
		array.insert(5);
		array.insert(3);
		array.insert(66);
		array.insert(77);
		array.insert(14);
		array.insert(1);
		array.insert(2);
		
		array.display();
		
		boolean finder = array.find(55);
		System.out.println(finder);
		
		array.delete(14);
		array.delete(77);
		array.delete(3);
		
		array.display();
	}
}