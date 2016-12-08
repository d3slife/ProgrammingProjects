package chap05.task52;

public class DoublyLinkedList {
    private Link first;
    private Link last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void displayForward() {
        System.out.println("Elements from first to last:");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }

    public void displayBackward() {
        System.out.println("Elements from last to first:");
        Link current = last;
        while (current != null) {
            current.displayLink();
            current = current.previous;
        }
    }

    public void insertFirst(int iValue) {
        Link newLink = new Link(iValue);

        if (isEmpty()) {
            last = newLink;
        } else {
            first.previous = newLink;
            newLink.next = first;
        }
        first = newLink;
    }

    public void insertLast(int iValue) {
        Link newLink = new Link(iValue);

        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
    }

    public boolean insertAfter(int iKey, int iValue) {
        Link current = first;

        while (current.iValue != iKey) {
            current = current.next;
            if (current == null) {
                return false;
            }
        }
        Link newLink = new Link(iValue);

        if (current == last) {
            last.next = newLink;
            last = newLink;
        } else {
            current.next.previous = newLink;
            newLink.next = current.next;
        }
        newLink.previous = current;
        current.next = newLink;
        return true;
    }

    public Link deleteKey(int iKey) {
        Link current = first;

        while (current.iValue != iKey) {
            current = current.next;
            if (current == null) {
                return null;
            }
        }
        if (current == last) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }
        if (current == first) {
            first = current.next;
        } else {
            current.previous.next = current.next;
        }
        return current;
    }

    public Link deleteFirst() {
        Link current = first;
        if (current.next == null) {
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
        return current;
    }

    public Link deleteLast() {
        Link current = last;
        if (current.previous == null) {
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        return current;
    }
}
