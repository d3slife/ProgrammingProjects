package chap05.task54;

public class Stack {
    private SinglyLinkedList list;

    public Stack() {
        list = new SinglyLinkedList();
    }

    public void displayStack() {
        list.displayList();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void insert(int iKey) {
        list.insert(iKey);
    }

    public void delete() {
        System.out.println("Has been deleted: " + list.delete().iValue);
    }
}
