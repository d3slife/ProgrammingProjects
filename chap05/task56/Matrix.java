package chap05.task56;

public class Matrix {
    private Link first;
    private int rowNumber;
    private int columnNumber;

    public Matrix(int rowNumber, int columnNumber) {
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        first = new Link();
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void generateMatrix() {
        Link current = first;
        for (int i = 0; i < columnNumber - 1; i++) {
            Link temp = current;
            Link temp2 = current;
            for (int j = 0; j < rowNumber; j++) {
                if (i == 0 && j < rowNumber - 1) {
                    temp.bottom = new Link();
                }
                if (i < columnNumber - 1) {
                    temp.right = new Link();
                    if (j == 0) {
                        current = temp.right;
                    }
                    if (j < rowNumber && j != 0) {
                        temp2.bottom = temp.right;
                    }
                    temp2 = temp.right;
                }
                if (j < rowNumber - 1) {
                    temp = temp.bottom;
                }
            }
        }
    }

    public void displayMatrix() {
        Link current = first;
        for (int i = 0; i < rowNumber; i++) {
            Link temp = current;
            for (int j = 0; j < columnNumber; j++) {
                temp.displayLink();
                System.out.print(" ");
                temp = temp.right;
            }
            current = current.bottom;
            System.out.println();
        }
    }

    public void displayString() {
        Link temp = first;
        for (int i = 0; i < columnNumber; i++) {
            temp.displayLink();
            System.out.print(" ");
            temp = temp.right;
        }
    }

    public void insertValue(int x, int y, int iValue) {
        if (x < 0 || x > columnNumber) {
            System.out.println("False x value was passed!");
        }
        if (y < 0 || y > rowNumber) {
            System.out.println("False y value was passed!");
        } else {
            Link current = first;
            for (int i = 0; i < x - 1; i++) {
                current = current.right;
            }
            for (int j = 0; j < y - 1; j++) {
                current = current.bottom;
            }
            current.iValue = iValue;
        }
    }
}
