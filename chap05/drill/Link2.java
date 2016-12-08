package chap05.drill;

public class Link2 {
    public int iValue;
    public Link2 next;
    public Link2 previous;

    public Link2(int iValue) {
        this.iValue = iValue;
        next = null;
        previous = null;
    }

    public void displayLink2() {
        System.out.println("Integer value is: " + this.iValue);
    }
}
