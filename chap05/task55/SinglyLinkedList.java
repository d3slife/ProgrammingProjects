package chap05.task55;

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
        if (isEmpty()) {
            current = new Link(iValue);
            current.next = current;
        } else {
            Link newLink = new Link(iValue);
            newLink.next = current.next;
            current.next = newLink;
            current = newLink;
        }
        quantity++;
    }

    public Link step() {
        current = current.next;
        return current;
    }

    public Link getCurrent() {
        return current;
    }

    public int delete() {
        if (quantity == 0) {
            System.out.println("Circle is empty!");
            return quantity;
        } else if (quantity == 1) {
            Link temp = current;
            current = null;
            quantity--;
            System.out.println(temp.iValue + " is the only element that has left!");
            return quantity;
        } else {
            Link temp = current.next;
            current.next = current.next.next;
            quantity--;
            System.out.println(temp.iValue + " has been successfully deleted!");
            return quantity;
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
        Link temp = current.next;
        while (iteration <= quantity) {
            temp.displayLink();
            iteration++;
            temp = temp.next;
        }
    }
}