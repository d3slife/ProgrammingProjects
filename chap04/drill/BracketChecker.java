package chap04.drill;

public class BracketChecker {
	
	private String input;
	private String output;
	
	public BracketChecker(String input) {
		this.input = input;
	}
	
	public void check() {
		int length = input.length();
		StackArrayChar stack = new StackArrayChar(length);
		
		for(int i = 0; i < length; i++) {
			char value = input.charAt(i);
			switch(value) {
				case '(':
				case '{':
				case '[':
					stack.push(value);
					break;
					
				case ')':
				case '}':
				case ']':
					if(!stack.isEmpty()) {
						char temp = stack.peek();
						if((value == ')' && temp != '(') || (value == '}' && temp != '{') || (value == '[' && temp != ']')) {
							System.out.println("Succession is wrong. Bracket " + value + " at index " + i + " is wrong.");
						}
						else {
							stack.pop();
						}
					} else {
						System.out.println("Succession is wrong. Check your expression.");
					}
					break;
				default: break;
			}
		}
		System.out.println("Everything went OK.");
	}
}