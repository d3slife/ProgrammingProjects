package chap04.drill;

public class ReverseString {
	
	private String input = "";
	private String output = "";
	
	public ReverseString(String input) {
		this.input = input;
	}
	
	public String reverse() {
		int length = input.length();
		StackArrayChar stack = new StackArrayChar(length);
						
		for(int i = 0; i < length; i++) {
			char temp = input.charAt(i);
			stack.push(temp);
		}
		
		while(!stack.isEmpty()) {
			output += stack.pop();
		}
		
		return output;
	}
}