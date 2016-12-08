package chap08.task85;

public class TreesQueue {

    private Tree[] ordQueue;
    private int maxSize;
    private int elemN;

    public TreesQueue(int size) {
        maxSize = size;
        ordQueue = new Tree[maxSize];
        elemN = 0;
    }

    public void insert(Tree newTree) {
        ordQueue[elemN++] = newTree;
    }

    public Tree delete() {
        if (!isEmpty()) {
            int min = elemN - 1;
            Tree temp;
            for(int i = elemN - 1; i > 0; i--) {
                // Comparing frequency of the trees;
                if (ordQueue[min].totalFreq > ordQueue[i - 1].totalFreq) {
                    min = i - 1;
                }
            }
            temp = ordQueue[min];
            for(int j = min; j < elemN - 1; j++) {
                ordQueue[j] = ordQueue[j + 1];
            }
            elemN--;
            return temp;
        } else {
            System.out.println("Queue is already empty");
            return null;
        }
    }

    public boolean isEmpty() {
        return (elemN == 0);
    }

    public boolean isFull() {
        return (elemN == maxSize);
    }

    public int getElemN() {
        return this.elemN;
    }

    // Return last added Tree element;
    public Tree peek() {
        return ordQueue[elemN];
    }
}