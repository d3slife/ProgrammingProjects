package chap12.task121;

public class HeapApp {

    public static void main(String[] args) {

        Heap heap = new Heap(31);
        heap.insert(70);
        heap.insert(40);
        heap.insert(50);
        heap.insert(20);
        heap.insert(60);
        heap.insert(100);
        heap.insert(80);
        heap.insert(30);
        heap.insert(10);
        heap.insert(90);
        heap.displayHeap();

        heap.insert(5);
        heap.displayHeap();

        heap.change(9, 3);
        heap.displayHeap();

    }
}
