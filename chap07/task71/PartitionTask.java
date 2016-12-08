package chap07.task71;

public class PartitionTask {

    private int[] array;
    private int size;

    public PartitionTask(int size) {
        this.size = size;
        this.array = new int[size];
        this.insertItems();
    }

    public int partitionIt(int left, int right) {
        int pivot = right;
        System.out.println("Pivot point is: " + array[right]);
        int leftPtr = left - 1;
        int rightPtr = right;
        while (true) {
            while (array[++leftPtr] < array[pivot]) {
                ;
            }
            while (rightPtr > left && array[--rightPtr] > array[pivot]) {
                ;
            }

            if (leftPtr >= rightPtr) {
                System.out.println("Failed");
                System.out.println("Element from left: " + array[leftPtr]);
                System.out.println("Element from right: " + array[rightPtr]);
                break;
            } else {
                System.out.println("Element from left: " + array[leftPtr]);
                System.out.println("Element from right: " + array[rightPtr]);
                swap(leftPtr, rightPtr);
                display();
            }
        }
        swap(leftPtr, pivot);
        return leftPtr;
    }

    public void swap(int dex1, int dex2) {
        int temp = array[dex1];
        array[dex1] = array[dex2];
        array[dex2] = temp;
    }

    public void insertItems() {
        for(int i = 0; i < array.length; i++) {
            int current = (int) (java.lang.Math.random() * 10);
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

        PartitionTask alg = new PartitionTask(10);
        alg.display();
        alg.partitionIt(0, alg.size - 1);
        alg.display();
    }
}
