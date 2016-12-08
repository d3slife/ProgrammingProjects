package chap07.task75;

public class Link {
    public int iValue;
    public Link next;

    public Link(int iValue) {
        this.iValue = iValue;
        next = null;
    }

    public void displayLink() {
        System.out.println("{ " + iValue + " }");
    }
}
