package chap07.task75;

public class LinkedList {

    private Link first;
    private Link last;

    public LinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int iValue) {
        Link newLink = new Link(iValue);

        if (isEmpty()) {
            last = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(int iValue) {
        Link newLink = new Link(iValue);

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
