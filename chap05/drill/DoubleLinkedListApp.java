package chap05.drill;

public class DoubleLinkedListApp {

    public static void main(String[] args) {

        DoubleLinkedList list = new DoubleLinkedList();
        list.insertFirst(40, 40.0);
        list.insertFirst(30, 30.0);
        list.insertFirst(20, 20.0);
        list.insertFirst(10, 10.0);

        list.insertLast(50, 50.0);
        list.insertLast(60, 60.0);

        list.displayList();

        Link deletedLink = list.deleteFirst();
        System.out.println("Item with following values has been deleted: ");
        deletedLink.displayLink();

        deletedLink = list.deleteFirst();
        System.out.println("Item with following values has been deleted: ");
        deletedLink.displayLink();

        list.displayList();
    }
}