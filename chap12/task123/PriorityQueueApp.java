package chap12.task123;

public class PriorityQueueApp {

    public static void main(String[] args) {

        PriorityQueue queue = new PriorityQueue(31);

        queue.insert(44);
        queue.insert(33);
        queue.insert(77);
        queue.insert(11);
        queue.insert(99);
        queue.displayQueue();

        for(int i = 0; i < queue.getSize();) {
            System.out.print(queue.remove() + "; ");
        }
        System.out.println();
    }
}
