package chap05.drill;

public class LinkedStack {

    private LinkedList list;

    public LinkedStack() {
        list = new LinkedList();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void displayStack() {
        list.displayList();
    }

    public void push(int iValue, double dValue) {
        list.insertFirst(iValue, dValue);
    }

    public void pop() {
        System.out.println("Object with the following values has been deleted:");
        list.deleteFirst().displayLink();
    }
}
