package chap12.task123;

public class PriorityQueue {

    private Heap heap;

    public PriorityQueue(int maxSize) {
       heap = new Heap(maxSize);
    }

    public boolean insert(int key) {
        return heap.insert(key);
    }

    public int remove() {
        return heap.remove().getKey();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void displayQueue() {
        heap.displayHeap();
    }

    public int getSize() {
        return heap.getCurrentSize();
    }
}
