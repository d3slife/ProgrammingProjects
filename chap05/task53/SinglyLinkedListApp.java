package chap05.task53;

public class SinglyLinkedListApp {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(20);
        list.insert(19);
        list.insert(18);
        list.insert(17);
        list.insert(16);
        list.insert(15);
        list.displayList();

        boolean value = list.search(0);
        System.out.println(value);

        value = list.search(20);
        System.out.println(value);

        list.delete();
        list.delete();
        list.displayList();
    }
}
