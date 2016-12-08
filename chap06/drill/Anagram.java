package chap06.drill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {

    static int size;
    static int count;
    static char[] arrChar = new char[100];

    public static void main(String[] args) throws IOException {

        System.out.print("Enter a word: ");     // Prompts to type a word;
        String input = getString();             // Evoke getString() method to obtain a String;
        size = input.length();                  // Get the length of the String;
        count = 0;                              // Initialize count variable (No need for that? Class field btw).
                                                // It will be later used in display method for displaying everything accurately;
        for (int j = 0; j < size; j++) {        // Initializing our char[] array with the letters of obtained String;
            arrChar[j] = input.charAt(j);
        }
        doAnagram(size);                        // Evoke doAnagram method, by passing size of obtain String;
    }

    public static void doAnagram(int newSize) {
        if (newSize == 1) {                     // If our size refers to only 1 letter, we immediately return;
            return;
        }
        for (int j = 0; j < newSize; j++) {     // 3
            doAnagram(newSize - 1);             //
            if (newSize == 2) {
                displayWord();                  // For the first time it displays word in its initial state;
            }
            rotate(newSize);                    //
        }
    }

    public static void rotate(int newSize) {    // 2
        int j;
        int position = size - newSize;          // 1
        char temp = arrChar[position];          // Char at 1 pos --> temp
        for (j = position + 1; j < size; j++) { // Shift chars
            arrChar[j - 1] = arrChar[j];        //
        }                                       //
        arrChar[j - 1] = temp;                  // Return temp to last pos
    }

    public static void displayWord() {          // This method was created only for fancy output;
        if (count < 99) {
            System.out.print(" ");
        }
        if (count < 9) {
            System.out.print(" ");
        }
        System.out.print(++count + " ");
        for (int j = 0; j < size; j++) {
            System.out.print(arrChar[j]);
        }
        System.out.print(" ");
        System.out.flush();
        if (count % 6 == 0) {
            System.out.println("");
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
