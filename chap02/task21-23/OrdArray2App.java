package chap02;

public class OrdArray2App {
	
	public static void main(String[] args) {
		
		OrdArray2 array = new OrdArray2(100);
		
		for(int i = 0; i < 20; i++) {
			long random = (long) (Math.random()*100);
			array.insert(random);
		}
		
		array.display();
	}
}