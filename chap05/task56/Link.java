package chap05.task56;

public class Link {
    public Link right;
    public Link bottom;
    public int iValue;

    public Link() {
        iValue = 0;
        right = null;
        bottom = null;
    }

    public void displayLink() {
        System.out.print(iValue);
    }

}
