package chap07.task71;

public class Partition {

    private int[] array;
    private int size;

    public Partition(int size) {
        this.size = size;
        this.array = new int[size];
        this.insertItems();
    }

    public int partitionIt(int left, int right, int pivot) {
        int leftPtr = left - 1;
        int rightPtr = right + 1;
        while (true) {
            while (leftPtr < right && array[++leftPtr] < pivot) {
                ;
            }
            while (rightPtr > left && array[--rightPtr] > pivot) {
                ;
            }

            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        return leftPtr;
    }

    public void swap(int dex1, int dex2) {
        int temp = array[dex1];
        array[dex1] = array[dex2];
        array[dex2] = temp;
    }

    public void insertItems() {
        for(int i = 0; i < array.length; i++) {
            int current = (int) (java.lang.Math.random() * 20);
            array[i] = current;
        }
    }

    public void display() {
        System.out.print("Array: ");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Partition alg = new Partition(10);
        alg.display();
        alg.partitionIt(0, alg.size - 1, 10);
        alg.display();
    }
}
