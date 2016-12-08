package chap12.task122;

public class HeapApp {

    public static void main(String[] args) {

        Heap heap = new Heap(31);

        heap.toss(10);
        heap.toss(20);
        heap.toss(50);
        heap.toss(30);
        heap.toss(100);
        heap.toss(44);
        heap.toss(55);
        heap.displayHeap();

        heap.restoreHeap();
        heap.displayHeap();


    }
}
