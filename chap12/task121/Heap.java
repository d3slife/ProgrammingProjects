package chap12.task121;

public class Heap {

    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        this.heapArray = new Node[maxSize];
    }

    // Doesn't matter whether it is descending or ascending heap;
    public boolean isEmpty() {
        return (this.currentSize == 0);
    }

    // Doesn't matter whether it is descending or ascending heap;
    public boolean insert(int key) {
        if (this.currentSize == this.maxSize) {
            return false;
        }
        Node newNode = new Node(key);
        heapArray[this.currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    // Changing comparison operator in while expression;
    public void trickleUp(int index) {
        int parent = (index - 1) / 2;
        Node bottom = heapArray[index];

        while(index > 0 && heapArray[parent].getKey() > bottom.getKey()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }

        heapArray[index] = bottom;
    }

    // Doesn't matter whether it is descending or ascending heap;
    public Node remove() {
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    // largerChild variable was substituted with smallerChild and some comparison operators where switched;
    public void trickleDown(int index) {
        int smallerChild;
        Node top = heapArray[index];

        while(index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            if (rightChild < currentSize && heapArray[leftChild].getKey() > heapArray[rightChild].getKey()) {
                smallerChild = rightChild;
            } else {
                smallerChild = leftChild;
            }

            if (top.getKey() <= heapArray[smallerChild].getKey()) {
                break;
            }
            heapArray[index] = heapArray[smallerChild];
            index = smallerChild;
        }

        heapArray[index] = top;
    }

    // Have to swap if else block of code;
    public boolean change(int index, int newValue) {
        if (index < 0 || index >= this.currentSize) {
            return false;
        }
        int oldValue = heapArray[index].getKey();
        heapArray[index].setKey(newValue);
        if (newValue > oldValue) {
            trickleDown(index);
        } else {
            trickleUp(index);
        }
        return true;
    }

    // Doesn't matter whether it is descending or ascending heap;
    public void displayHeap() {
        System.out.print("heapArray: ");
        for(int m = 0; m < currentSize; m++)
            if (heapArray[m] != null) {
                System.out.print( heapArray[m].getKey() + " ");
            } else {
                System.out.print("-- ");
            }
        System.out.println();

        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = "...............................";
        System.out.println(dots+dots);

        while(currentSize > 0) {
            if (column == 0) {
                for(int k = 0; k < nBlanks; k++) {
                    System.out.print(' ');
                }
            }
            System.out.print(heapArray[j].getKey());

            if(++j == currentSize) {
                break;
            }

            if(++column==itemsPerRow) {
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            } else {
                for (int k = 0; k < nBlanks * 2 - 2; k++) {
                    System.out.print(' ');
                }
            }
        }
        System.out.println("\n"+dots+dots);
    }
}