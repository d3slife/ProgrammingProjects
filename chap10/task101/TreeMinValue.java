package chap10.task101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TreeMinValue {

    public static void main(String[] args) throws IOException {

        Tree234 newTree = new Tree234();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String curString = reader.readLine();
            if (curString.equals("")) {
                break;
            } else {
                int curInt = Integer.parseInt(curString);
                newTree.insert(curInt);
            }
        }

        long minValue = newTree.getMin();
        System.out.println("Min value is: " + minValue);

        newTree.displayTree();
    }
}
