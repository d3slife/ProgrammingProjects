package chap05.task56;

public class MatrixApp {

    public static void main(String[] args) {
        Matrix matrix = new Matrix(5, 5);
        matrix.generateMatrix();
        System.out.println("The initial state of matrix is the following: ");
        matrix.displayMatrix();

        System.out.println("");
        System.out.println("Let's try to insert some values into matrix");
        matrix.insertValue(4, 4, 1);
        matrix.insertValue(3, 3, 1);
        matrix.insertValue(2, 2, 1);
        matrix.insertValue(1, 1, 1);
        matrix.insertValue(5, 5, 1);
        matrix.displayMatrix();
    }
}
