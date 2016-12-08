package chap05.task54;

public class Link {
    public int iValue;
    public Link next;

    public Link(int iValue) {
        this.iValue = iValue;
    }

    public void displayLink() {
        System.out.println("Element's value: " + this.iValue);
    }
}
