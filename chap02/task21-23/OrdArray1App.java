package chap02;

public class OrdArray1App {
	
	public static void main(String[] args) {
		int max = 100;
		OrdArray1 ordArray1 = new OrdArray1(max);
		
		ordArray1.insert(10);
		ordArray1.insert(1);		
		ordArray1.insert(34);
		ordArray1.insert(13);
		ordArray1.insert(5);
		ordArray1.insert(-3);
		ordArray1.insert(2);
		ordArray1.insert(0);
		ordArray1.insert(44);
		ordArray1.insert(8);
		
		ordArray1.display();
		
		int finder = ordArray1.find(33);
		System.out.println(finder);
		
		ordArray1.delete(10);
		ordArray1.delete(20);
		ordArray1.delete(2);
		
		ordArray1.display();
	}
}