package chap04.task43;

public class Dequeue {

    private long[] arrayDequeue;
    // private int front;
    // private int rear;
    private int maxSize;
    private int elemN;

    public Dequeue(int size) {
        maxSize = size;
        arrayDequeue = new long[maxSize];
        elemN = 0;
        // rear = -1;
        // front = 0;
    }

    /*
    public void insertLeft(long value) {
        if(!isFull()) {
            if(isEmpty()) {
                arrayDequeue[0] = value;
            } else if(front == 0) {
                front = maxSize - 1;
                arrayDequeue[front] = value;
                elemN++;
            } else {
                front--;
                arrayDequeue[front] = value;
                elemN++;
            }
        } else {
            System.out.println("Queue is full.");
        }
    }
    */

    public void insertRight(long value) {
        if(!isFull()) {
            /*
            if(rear == maxSize - 1) {
                rear = -1;
            }
            */
            arrayDequeue[elemN++] = value;
        } else {
            System.out.println("Queue is full.");
        }
    }

    /*
    public long removeLeft() {
        if(!isEmpty()) {
            long temp = arrayDequeue[front];
            front++;
            if(front == maxSize) {
                front = 0;
            }
            elemN--;
            return temp;
        } else {
            System.out.println("Queue is already empty.");
            return -1;
        }
    }
    */

    public long removeRight() {
        if(!isEmpty()) {
            long temp = arrayDequeue[elemN - 1];
            elemN--;
            /*
            if(rear == -1) {
                rear = maxSize - 1;
            }
            elemN--;
            */
            return temp;
        } else {
            System.out.println("Queue is already empty.");
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