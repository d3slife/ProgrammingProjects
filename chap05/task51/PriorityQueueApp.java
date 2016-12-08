package chap05.task51;

public class PriorityQueueApp {

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();

        queue.insert(4);
        queue.insert(10);
        queue.insert(-60);
        queue.insert(0);
        queue.displayQueue();

        queue.delete();
        queue.delete();
        queue.displayQueue();
    }
}
