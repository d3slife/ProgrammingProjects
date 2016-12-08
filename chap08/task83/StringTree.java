package chap08.task83;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringTree {

    private char[] charArray;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please type random string in: ");
        String s = reader.readLine();
        char[] charArray = s.toCharArray();

        StringTree stringTree = new StringTree();
        stringTree.charArray = charArray;


        Tree finalTree = stringTree.completeTree(charArray);
        finalTree.displayTree();
    }

    public Tree completeTree(char[] charArray) {

        if (charArray.length == 1) {
            Tree newTree = new Tree(new Node(charArray[0]));
            return newTree;
        } else {
            Tree newTree = new Tree(new Node(charArray[0]));
            recMethod(1, newTree);
            return newTree;
        }
    }

    public void recMethod(int n, Tree tree) {
        if (2 * n <= charArray.length) {
            Tree newTreeLeft = new Tree(new Node(charArray[2 * n - 1]));
            tree.getRoot().leftChild = newTreeLeft.getRoot();
            recMethod(2 * n, newTreeLeft);
        }
        if (2 * n + 1 <= charArray.length) {
            Tree newTreeRight = new Tree(new Node(charArray[2 * n]));
            tree.getRoot().rightChild = newTreeRight.getRoot();
            recMethod(2 * n + 1, newTreeRight);
        }
    }
}