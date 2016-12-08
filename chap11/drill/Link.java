package chap11.drill;

public class Link {

    private int iData;
    public Link next;

    public Link(int iData) {
        this.iData = iData;
    }

    public int getKey() {
        return this.iData;
    }

    public void displayLink() {
        System.out.print(iData + " ");
    }
}
