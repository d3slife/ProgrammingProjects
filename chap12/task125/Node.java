package chap12.task125;

public class Node {

    public int iData;
    public Node leftChild;
    public Node rightChild;
    public Node parent;

    public Node(Node parent, int iData) {
        this.iData = iData;
        this.parent = parent;
    }

    public void displayNode() {
        System.out.print("{" + iData + "} ");
    }
}