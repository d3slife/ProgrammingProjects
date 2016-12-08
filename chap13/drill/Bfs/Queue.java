package chap13.drill.Bfs;

public class Queue {

    private final int SIZE = 20;
    private int[] queArray;
    private int front;
    private int rear;

    public Queue() {
        this.queArray = new int[this.SIZE];
        this.front = 0;
        this.rear = -1;
    }

    public void insert(int j) {
        if (this.rear == this.SIZE - 1) {
            this.rear = -1;
        }
        this.queArray[++this.rear] = j;
    }

    public int remove() {
        int temp = this.queArray[front++];
        if (this.front == this.SIZE) {
            this.front = 0;
        }
        return temp;
    }

    public boolean isEmpty() {
        return ((this.rear + 1 == this.front) || (this.front + this.SIZE - 1 == this.rear));
    }
}
