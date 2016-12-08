package chap08.task85;

public class Node {

    public String s;
    public int freq;
    public Node leftChild;
    public Node rightChild;
    public String code;

    public Node(String s, int freq) {
        this.s = s;
        this.freq = freq;
    }

    public void displayNode() {
        System.out.println("{" + s + "} " + "{" + freq + "};");
    }

    public void displayCode() {
        System.out.println("{" + s + "} " + "{" + code + "};");
    }
}