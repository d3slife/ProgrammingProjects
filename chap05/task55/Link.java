package chap05.task55;

public class Link {
    public Link next;
    public int iValue;

    public Link(int iValue) {
        this.next = null;
        this.iValue = iValue;
    }

    public void displayLink() {
        System.out.println("Link's value is: " + iValue);
    }
}
