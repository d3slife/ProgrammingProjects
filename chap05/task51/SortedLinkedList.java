package chap05.task51;

public class SortedLinkedList {

    private Link first;

    public SortedLinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertValue(int iKey) {
        Link current = first;
        Link previous = null;

        while (current != null && iKey > current.iValue) {
            previous = current;
            current = current.next;
        }

        Link newLink = new Link(iKey);
        if (previous == null) {
            first = newLink;
        } else {
            previous.next = newLink;
        }
        newLink.next = current;
    }

    public Link removeFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        Link current = first;
        System.out.println("Displaying values: ");
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }
}