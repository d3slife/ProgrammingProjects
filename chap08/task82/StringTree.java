package chap08.task82;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringTree {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please type random string in: ");
        String s = reader.readLine();

        char[] charArray = s.toCharArray();
        Tree finalTree = balancedTree(charArray);
        finalTree.displayTree();
    }

    public static Tree balancedTree(char[] charArray) {

        if (charArray.length == 1) {
            Tree newTree = new Tree(new Node(charArray[0]));
            return newTree;
        }

        Tree[] treesArray = new Tree[charArray.length];

        int i = 0;
        for(char symbol : charArray) {
            Tree newTree = new Tree(new Node(symbol));
            treesArray[i] = newTree;
            i++;
        }

        int limit = treesArray.length / 2;
        while (limit >= 1) {
            int j;
            for (j = 0; j < limit; j++) {
                Tree newTree = new Tree(new Node('+'));
                newTree.getRoot().leftChild = treesArray[2 * j].getRoot();
                newTree.getRoot().rightChild = treesArray[2 * j + 1].getRoot();
                treesArray[j] = newTree;
            }
            limit /= 2;
        }

        if (charArray.length % 2 != 0) {
            Tree finalTree = new Tree(new Node('+'));
            finalTree.getRoot().leftChild = treesArray[0].getRoot();
            finalTree.getRoot().rightChild = treesArray[charArray.length - 1].getRoot();
            treesArray[0] = finalTree;
        }
        return treesArray[0];
    }
}