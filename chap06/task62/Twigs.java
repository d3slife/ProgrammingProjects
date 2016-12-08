package chap06.task62;

public class Twigs {

    private String[][] array;
    private int curHeight;

    public Twigs(int width) {
        int height = (int) (Math.log10(width) / Math.log10(2) + 1);
        array = new String[height][width];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = "-";
            }
        }
        display();
        System.out.println();
        makeBranches(0, width, 0);
        display();
    }

    public void makeBranches(int left, int right, int curHeight) {
        if (curHeight == array.length) {
            return;
        } else {
            int mid = (left + right) / 2;
            array[curHeight++][mid] = "X";
            makeBranches(left, mid, curHeight);
            makeBranches(mid, right, curHeight);
        }
    }

    public void display() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}
