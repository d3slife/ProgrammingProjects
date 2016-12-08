package chap07.task73;

public class PartitionTask{

    private long[] theArray;
    private int nElems;
    private int median;
    private int left;
    private int right;

    public PartitionTask(int max) {
        this.theArray = new long[max];
        this.nElems = 0;
        this.median = max / 2;
        this.left = 0;
        this.right = max - 1;
    }

    public void insert(long value) {
        theArray[nElems] = value;
        nElems++;
    }

    public void display() {
        System.out.print("Array: ");
        for(int i = 0; i < nElems; i++) {
            System.out.print(theArray[i] + " ");
        }
        System.out.println();
    }

    public void start() {
        median(left, right);
    }

    public void median(int left, int right) {
        int current = partitionIt(left, right, theArray[right]);
        System.out.println("Current is: " + current + ", with value: " + theArray[current]);
        if (current == median) {
            System.out.println("Success!");
        } else if (current > median) {
            this.right = current - 1;
            median(left, this.right);
        } else {
            this.left = current + 1;
            median(this.left, right);
        }
    }

    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;
        // System.out.println("Pivot: " + pivot + "; Left: " + left + "; Right: " + right);
        while(true) {
            while(theArray[++leftPtr] < pivot) {
                ;
            }
            // System.out.print("Left value: " + theArray[leftPtr]);
            while(rightPtr > 0 && theArray[--rightPtr] > pivot) {
                ;
            }
            // System.out.print(" Right value: " + theArray[rightPtr]);
            // System.out.print(" Left pointer: " + leftPtr);
            // System.out.println(" Right pointer: " + rightPtr);
            if (leftPtr >= rightPtr) {
                // System.out.println("Return");
                break;
            } else {
                swap(leftPtr, rightPtr);
                // display();
                // System.out.println();
            }
        }
        swap(leftPtr, right);
        // display();
        // System.out.println("Breaking loop. LeftPtr is: " + leftPtr);
        // System.out.println();
        return leftPtr;
    }

    public void swap(int dex1, int dex2) {
        long temp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = temp;
    }

    public static void main(String[] args) {
        int max = 15;
        PartitionTask task = new PartitionTask(max);

        for(int i = 0; i < max; i++) {
            long n = (long)(java.lang.Math.random() * 15);
            task.insert(n);
        }

        task.display();
        task.start();
        task.display();
    }
}

