package chap05.drill;

public class DoublyLinkedList {
    private Link2 first;
    private Link2 last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void displayForward() {
        System.out.println("Elements from first to last:");
        Link2 current = first;
        while (current != null) {
            current.displayLink2();
            current = current.next;
        }
    }

    public void displayBackward() {
        System.out.println("Elements from last to first:");
        Link2 current = last;
        while (current != null) {
            current.displayLink2();
            current = current.previous;
        }
    }

    public void insertFirst(int iValue) {
        Link2 newLink = new Link2(iValue);

        if (isEmpty()) {
            last = newLink;
        } else {
            first.previous = newLink;
            newLink.next = first;
        }
        first = newLink;
    }

    public void insertLast(int iValue) {
        Link2 newLink = new Link2(iValue);

        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
    }

    public boolean insertAfter(int iKey, int iValue) {
        Link2 current = first;

        while (current.iValue != iKey) {
            current = current.next;
            if (current == null) {
                return false;
            }
        }
        Link2 newLink = new Link2(iValue);

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

    public Link2 deleteKey(int iKey) {
        Link2 current = first;

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

    public Link2 deleteFirst() {
        Link2 current = first;
        if (current.next == null) {
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
        return current;
    }

    public Link2 deleteLast() {
        Link2 current = last;
        if (current.previous == null) {
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        return current;
    }
}
