package chap04.task43;

public class DequeueApp {

    public static void main(String[] args) {

        int size = 5;
        Dequeue dequeue = new Dequeue(size);

        dequeue.insertRight(5);
        dequeue.insertRight(6);
        dequeue.insertRight(7);
        dequeue.insertRight(8);
        dequeue.insertRight(9);

        while(!dequeue.isEmpty()) {
            long value = dequeue.removeRight();
            System.out.println(value);
        }
    }
}
