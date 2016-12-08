package chap07.task72;

public class QuickSort {

    private long[] theArray;
    private int nElems;
    private int comparisons;
    private int copies;

    public QuickSort(int max) {
        this.theArray = new long[max];
        this.nElems = 0;
        this.comparisons = 0;
        this.copies = 0;
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

    public void quickSort() {
        recQuickSort(0, nElems - 1);
    }

    public void recQuickSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 3) {
            manualSort(left, right);
        } else {
            long median = medianOf3(left, right);
            int partition = partitionIt(left, right, median);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }

    public long medianOf3(int left, int right) {
        this.comparisons += 3;                                           // Task 7.2;
        int center = (left + right) / 2;

        if(theArray[left] > theArray[center]) {
            swap(left, center);
        }

        if(theArray[left] > theArray[right]) {
            swap(left, right);
        }

        if(theArray[center] > theArray[right]) {
            swap(center, right);
        }

        swap(center, right - 1);
        return theArray[right - 1];
    }

    public void swap(int dex1, int dex2) {
        this.copies += 3;                                               // Task 7.2;
        long temp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = temp;
    }

    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left;
        int rightPtr = right - 1;

        while (true) {
            while (theArray[++leftPtr] < pivot) {
                this.comparisons++;
            }
            while (theArray[--rightPtr] > pivot) {
                this.comparisons++;
            }
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        swap(leftPtr, right - 1);
        return leftPtr;
    }

    public void manualSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 1) {
            return;
        } else if (size == 2) {
            if (theArray[left] > theArray[right]) {
                comparisons++;
                swap(left, right);
            }
            return;
        } else {
            if (theArray[left] > theArray[right - 1]) {
                comparisons += 2;
                swap(left, right - 1);
            }
            if (theArray[left] > theArray[right]) {
                comparisons++;
                swap(left, right);
            }
            if (theArray[right - 1] > theArray[right]) {
                comparisons++;
                swap(right - 1, right);
            }
        }
        System.out.println("Number of comparisons: " + comparisons + "; Number of copies: " + copies);
    }

    public static void main(String[] args) {
        int maxSize = 12;
        QuickSort arr = new QuickSort(maxSize);
        for(int j = 0; j < maxSize; j++) {
            // long n = (long) (java.lang.Math.random() * 99);
            arr.insert(maxSize - j);
        }
        arr.display();
        arr.quickSort();
        arr.display();
    }
}