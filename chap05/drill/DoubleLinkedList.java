package chap05.drill;

public class DoubleLinkedList {

    private Link first;
    private Link last;

    public DoubleLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int iValue, double dValue) {
        Link newLink = new Link(iValue, dValue);

        if (isEmpty()) {
            last = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(int iValue, double dValue) {
        Link newLink = new Link(iValue, dValue);

        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }

    public Link deleteFirst() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return null;
        } else {
            Link current = first;
            if (first.next == null) {
                last = null;
            }
            first = first.next;
            return current;
        }
    }

    public void displayList() {
        System.out.println("List items from first to last:");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }
}
