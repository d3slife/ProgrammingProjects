package chap06.task63;

public class Multiplication {

    public static int power(int x, int y) {
        if (y == 1) {
            return x;
        } else if (y % 2 == 0){
            return (x * power(x, y / 2));
        } else {
            return (x * x * power(x, y / 2));
        }
    }

    public static void main(String[] args) {
        System.out.println(power(2, 2));
        System.out.println(power(2, 5));
        System.out.println(power(2, 4));
        System.out.println(power(3, 3));
    }
}
