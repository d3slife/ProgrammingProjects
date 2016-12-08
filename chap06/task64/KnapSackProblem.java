package chap06.task64;

public class KnapSackProblem {

    private int[] array;
    private int target;
    private int startPoint;
    private int elemN;

    public KnapSackProblem() {
        array = new int[]{11, 8, 7, 6, 5};
        startPoint = 1;
        target = 20;
        knapsack(target, 0);
    }

    public void knapsack(int target, int i) {
        if (i >= array.length) {
            startPoint++;
            knapsack(this.target - array[startPoint - 2], startPoint);
        } else {
            if (array[i] > target) {
                System.out.println("Target is: " + target + "; Current element is: " + array[i]);
                knapsack(target, ++i);
            } else if (array[i] < target) {
                elemN = i;
                System.out.println("Target is: " + target + "; Current element is: " + array[i]);
                knapsack(target - array[i], ++i);
            } else {
                System.out.println("Target is: " + target + "; Current element is: " + array[i]);
                System.out.println("Success!");
            }
        }
    }

    public static void main(String[] args) {
        KnapSackProblem problem = new KnapSackProblem();
    }
}
