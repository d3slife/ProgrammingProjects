package chap10.task102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InorderTraverse {

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

        newTree.inorderStart();
    }
}
