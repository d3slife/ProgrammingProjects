package chap12.task122;

public class Heap {

    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        this.heapArray = new Node[maxSize];
    }

    public boolean toss(int key) {
        if (this.currentSize == this.maxSize) {
            return false;
        }
        Node newNode = new Node(key);
        heapArray[this.currentSize] = newNode;
        this.currentSize++;
        return true;
    }

    public void restoreHeap() {
        for(int j = this.currentSize / 2 - 1; j >= 0; j--) {
            trickleDown(j);
        }
    }

    public boolean isEmpty() {
        return (this.currentSize == 0);
    }

    public boolean insert(int key) {
        if (this.currentSize == this.maxSize) {
            return false;
        }
        Node newNode = new Node(key);
        heapArray[this.currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    public void trickleUp(int index) {
        int parent = (index - 1) / 2;
        Node bottom = heapArray[index];

        while(index > 0 && heapArray[parent].getKey() < bottom.getKey()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }

        heapArray[index] = bottom;
    }

    public Node remove() {
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    public void trickleDown(int index) {
        int largerChild;
        Node top = heapArray[index];

        while(index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            if (rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey()) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }

            if (top.getKey() >= heapArray[largerChild].getKey()) {
                break;
            }
            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }

        heapArray[index] = top;
    }

    public boolean change(int index, int newValue) {
        if (index < 0 || index >= this.currentSize) {
            return false;
        }
        int oldValue = heapArray[index].getKey();
        heapArray[index].setKey(newValue);
        if (newValue > oldValue) {
            trickleUp(index);
        } else {
            trickleDown(index);
        }
        return true;
    }

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