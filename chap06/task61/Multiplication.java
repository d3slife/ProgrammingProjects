package chap06.task61;

public class Multiplication {

    public int mult(int x, int y) {
        if (y == 1) {
            return x;
        } else {
            return (x + mult(x, y - 1));
        }
    }
}
