package chap05.task51;

public class PriorityQueue {
    private SortedLinkedList list;

    public PriorityQueue() {
        list = new SortedLinkedList();
    }

    public void insert(int iKey) {
        list.insertValue(iKey);
    }

    public void delete() {
        System.out.println("Item with the following value was removed: ");
        list.removeFirst().displayLink();
    }

    public void displayQueue() {
        list.displayList();
    }
}
