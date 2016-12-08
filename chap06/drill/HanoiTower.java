package chap06.drill;

public class HanoiTower {

    private int elemN;
    private char start;
    private char inter;
    private char destin;

    public HanoiTower(int elemN) {
        this.elemN = elemN;
        this.start = 'A';
        this.inter = 'B';
        this.destin = 'C';
        doTower(this.elemN, this.start, this.inter, this.destin);
    }

    public void doTower(int elemN, char start, char inter, char destin) {
        if (elemN == 1) {
            System.out.println("Element number 1 moved from " + start + " to " + destin);
        } else {
            doTower(elemN - 1, start, destin, inter);
            System.out.println("Element number " + elemN + " moved from " + start + " to " + destin);
            doTower(elemN - 1, inter, start, destin);
        }
    }
}
