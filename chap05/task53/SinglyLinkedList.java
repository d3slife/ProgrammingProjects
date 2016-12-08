package chap05.task53;

public class SinglyLinkedList {
    private Link current;
    private int quantity;

    public SinglyLinkedList() {
        current = null;
        quantity = 0;
    }

    public boolean isEmpty() {
        return (current == null);
    }

    public void insert(int iValue) {
        if (current == null) {
            current = new Link(iValue);
            current.next = current;
        } else {
            Link newLink = new Link(iValue);
            newLink.next = current.next;
            current.next = newLink;
        }
        quantity++;
    }

    public Link delete() {
        if (isEmpty()) {
            return null;
        } else if (quantity == 1) {
            Link temp = current;
            current = null;
            quantity--;
            return temp;
        } else {
            Link temp = current.next;
            current.next = current.next.next;
            quantity--;
            return temp;
        }
    }

    public boolean search(int iKey) {
        int iteration = 1;
        while (iteration <= quantity) {
            if (current.iValue == iKey) {
                return true;
            }
            current = current.next;
            iteration++;
        }
        return false;
    }

    public void displayList() {
        int iteration = 1;
        while (iteration <= quantity) {
            current.displayLink();
            iteration++;
            current = current.next;
        }
    }
}