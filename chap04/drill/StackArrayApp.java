package chap04.drill;

public class StackArrayApp {
	
	public static void main(String[] args) {
		
		StackArray stack = new StackArray(5);
		
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		stack.push(0);
		
		while(!stack.isEmpty()) {
			long value = stack.pop();
			System.out.println(value);
		}
	}
}