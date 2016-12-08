package chap05.drill;

public class LinkedList {
    private Link first;

    public LinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int iValue, double dValue) {
        Link newLink = new Link(iValue, dValue);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst() {
        if (isEmpty()) {
            System.out.println("Linked list is empty.");
            return null;
        } else {
            Link temp = first;
            first = first.next;
            return temp;
        }
    }

    public void displayList() {
        System.out.println("From first to last:");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }

    public Link findItem(int iValue) {
        Link current = first;
        while(current.iValue != iValue) {
            if (current == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public Link deleteItem(int iValue) {
        Link current = first;
        Link previous = first;

        while(current.iValue != iValue) {
            if (current == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }

        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }
}
