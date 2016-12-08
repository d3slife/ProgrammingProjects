package chap08.task82;

public class Node {

    public char charSymbol;
    // public double dData;
    public Node leftChild;
    public Node rightChild;

    public Node(char charSymbol) {
        this.charSymbol = charSymbol;
    }

    public void displayNode() {
        System.out.print("{");
        System.out.print(charSymbol);
        System.out.print("} ");
    }
}