package chap05.task52;

public class Link {
    public int iValue;
    public Link next;
    public Link previous;

    public Link(int iValue) {
        this.iValue = iValue;
        next = null;
        previous = null;
    }

    public void displayLink() {
        System.out.println("Integer value is: " + iValue);
    }
}
