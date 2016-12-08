package chap08.task81;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringTree {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please type random string in: ");
        String s = reader.readLine();

        char[] charArray = s.toCharArray();
        // Node[] nodesArray = new Node[charArray.length];
        Tree[] treesArray = new Tree[charArray.length];

        int i = 0;
        for(char symbol : charArray) {
            treesArray[i] = new Tree(new Node(symbol));
            i++;
        }

        for(int j = 0; j < treesArray.length - 1; j++) {
            Tree root = new Tree(new Node('+'));
            root.getRoot().leftChild = treesArray[j].getRoot();
            root.getRoot().rightChild = treesArray[j + 1].getRoot();
            System.out.println("Successfully added: " + j);
            treesArray[j] = null;
            treesArray[j + 1] = root;
        }

        Tree finalTree = treesArray[treesArray.length - 1];
        finalTree.displayTree();
    }
}
