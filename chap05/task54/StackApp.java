package chap05.task54;

public class StackApp {

    public static void main(String[] args) {

        Stack stack = new Stack();

        stack.insert(10);
        stack.insert(20);
        stack.insert(30);
        stack.insert(40);
        stack.displayStack();
        System.out.println();

        stack.delete();
        stack.displayStack();
        System.out.println();

        stack.delete();
        stack.displayStack();
        System.out.println();
    }
}
