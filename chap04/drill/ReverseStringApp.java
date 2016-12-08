package chap04.drill;

import java.io.*;

public class ReverseStringApp {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		String output = "";
				
		while(true) {
			System.out.println("Please type some string in.");
			input = reader.readLine();
			if(input.equals("")) {
				System.out.println("Program terminates.");
				break;
			} else {
				System.out.println("String you've entered is: " + input);			
				ReverseString reversed = new ReverseString(input);
				output = reversed.reverse();
				System.out.println("Reversed string is: " + output);
			}			
		}
	}
}