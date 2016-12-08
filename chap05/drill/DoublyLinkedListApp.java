package chap05.drill;

public class DoublyLinkedListApp {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertFirst(50);
        list.insertFirst(40);
        list.insertLast(60);
        list.insertLast(70);

        list.displayForward();
        list.displayBackward();

        list.deleteFirst();
        list.deleteLast();

        list.deleteKey(60);

        list.displayForward();
    }
}
