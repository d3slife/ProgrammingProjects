package chap05.drill;

public class LinkedQueueApp {

    public static void main(String[] args) {

        LinkedQueue queue = new LinkedQueue();
        queue.insert(10, 10.0);
        queue.insert(20, 20.0);
        queue.insert(30, 30.0);

        queue.displayQueue();

        queue.delete();
        queue.delete();

        queue.displayQueue();
    }
}
