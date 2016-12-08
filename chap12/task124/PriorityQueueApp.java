package chap12.task124;

public class PriorityQueueApp {

    public static void main(String[] args) {

        PriorityQueue queue = new PriorityQueue();

        queue.insert(10);
        queue.insert(4);
        queue.insert(33);
        queue.insert(20);
        queue.insert(7);
        queue.insert(50);
        queue.insert(17);
        queue.displayQueue();

        System.out.print("Removing elements in descending order: ");
        while(!queue.isEmpty()) {
            System.out.print(queue.removeMax() + "; ");
        }
        System.out.println();
    }
}
