package chap05.drill;

public class LinkedStackApp {

    public static void main(String[] args) {

        LinkedStack stack = new LinkedStack();

        stack.push(10, 10.0);
        stack.push(20, 20.0);
        stack.push(30, 30.0);
        stack.push(40, 40.0);

        stack.displayStack();

        stack.pop();
        stack.pop();

        stack.displayStack();
    }
}
