package chap05.drill;

public class LinkedListApp {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertFirst(20, 20.0);
        list.insertFirst(30, 30.0);
        list.insertFirst(40, 40.0);
        list.insertFirst(50, 50.0);
        list.displayList();

        Link locatedLink = list.findItem(30);
        System.out.println("Item has been found:");
        locatedLink.displayLink();

        Link deletedLink = list.deleteItem(40);
        System.out.println("Item has been deleted:");
        deletedLink.displayLink();

        System.out.println("Let's display list's elements");
        list.displayList();
    }
}
