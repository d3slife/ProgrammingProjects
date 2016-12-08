package chap04.task44;

public class OrderedQueueApp {

    public static void main(String[] args) {

        int size = 5;
        OrderedQueue queue = new OrderedQueue(size);

        for(int i = 0; i < size; i++) {
            long value = (long) (Math.random() * 10);
            queue.insert(value);
        }

        while(!queue.isEmpty()) {
            long temp = queue.delete();
            System.out.println(temp);
        }
    }
}