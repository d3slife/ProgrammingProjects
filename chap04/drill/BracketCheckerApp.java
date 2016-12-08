package chap04.drill;

import java.io.*;

public class BracketCheckerApp {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		
		while(true) {
			System.out.println("Type expression with brackets.");
			input = reader.readLine();
			if(input.equals("")) {
				System.out.println("Program terminates.");
				break;
			} else {
				BracketChecker checker = new BracketChecker(input);
				checker.check();
			}
		}
	}
}