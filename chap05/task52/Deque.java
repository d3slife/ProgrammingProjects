package chap05.task52;

public class Deque {
    private DoublyLinkedList list;

    public Deque() {
        list = new DoublyLinkedList();
    }

    public void insertLeft(int iValue) {
        list.insertFirst(iValue);
    }

    public void insertRight(int iValue) {
        list.insertLast(iValue);
    }

    public void removeLeft() {
        System.out.println("Left element has been left: " + list.deleteFirst().iValue);
    }

    public void removeRight() {
        System.out.println("Right element has been left: " + list.deleteLast().iValue);
    }

    public void displayQueForward() {
        list.displayForward();
    }

    public void displayQueBackward() {
        list.displayBackward();
    }
}