package chap06.drill;

public class TriangleMethodApp {

    public static void main(String[] args) {
        int temp = TriangleMethod.triangle(5);
        System.out.println(temp);

        temp = TriangleMethod.triangle(3);
        System.out.println(temp);

        temp = TriangleMethod.triangle(1000);
        System.out.println(temp);
    }
}
