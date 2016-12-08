package chap05.drill;

public class Link {
    public int iValue;
    public double dValue;
    public Link next;

    public Link(int iValue, double dValue) {
        this.iValue = iValue;
        this.dValue = dValue;
        next = null;
    }

    public void displayLink() {
        System.out.println("{ " + iValue + "; " + dValue + " }");
    }
}
