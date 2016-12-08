package chap05.task51;

public class Link {
    public int iValue;
    public Link next;

    public Link(int iValue) {
        this.iValue = iValue;
    }

    public void displayLink() {
        System.out.println("Integer value of the element: " + this.iValue);
    }
}
