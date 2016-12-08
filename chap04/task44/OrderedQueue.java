package chap04.task44;

public class OrderedQueue {

    private long[] ordQueue;
    private int maxSize;
    private int elemN;

    public OrderedQueue(int size) {
        maxSize = size;
        ordQueue = new long[maxSize];
        elemN = 0;
    }

    public void insert(long value) {
        ordQueue[elemN++] = value;
    }

    public long delete() {
        if(!isEmpty()) {
            int min = elemN - 1;
            long temp;
            for(int i = elemN - 1; i > 0; i--) {
                if(ordQueue[min] > ordQueue[i - 1]) {
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
            return -1;
        }
    }

    public boolean isEmpty() {
        return (elemN == 0);
    }

    public boolean isFull() {
        return (elemN == maxSize);
    }
}