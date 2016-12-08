package chap13.task132;

public class LinkedList {
    private Link first;
    private Link initLink;

    public LinkedList(Vertex vertex) {
        initLink = new Link(vertex);
        first = null;
    }

    public Link getInitLink() {
        return initLink;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(Vertex vertex) {
        Link newLink = new Link(vertex);
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
            System.out.print("-->");
            current = current.next;
        }
    }

    public Link findItem(char label) {
        Link current = first;
        while(current.vertex.label != label) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public int find() {
        Link current = first;
        while(true) {
            if (current == null) {
                return -1;
            } else if (current.vertex.wasVisited) {
                if (current.next == null) {
                    break;
                } else {
                    current = current.next;
                }
            } else {
                return current.vertex.getInt();
            }
        }
        return -1;
    }

    public Link deleteItem(char label) {
        Link current = first;
        Link previous = first;

        while(current.vertex.label != label) {
            if (current.next == null) {
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