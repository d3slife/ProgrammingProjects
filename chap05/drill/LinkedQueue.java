package chap05.drill;

public class LinkedQueue {

    private DoubleLinkedList list;

    public LinkedQueue() {
        list = new DoubleLinkedList();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void insert(int iValue, double dValue) {
        list.insertLast(iValue, dValue);
    }

    public void delete() {
        System.out.println("Element with the following values has left the queue:");
        list.deleteFirst().displayLink();
    }

    public void displayQueue() {
        list.displayList();
    }
}
