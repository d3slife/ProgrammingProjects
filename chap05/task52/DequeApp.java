package chap05.task52;

public class DequeApp {
    public static void main(String[] args) {
        Deque deque = new Deque();

        deque.insertLeft(30);
        deque.insertLeft(20);
        deque.insertLeft(10);
        deque.insertRight(40);
        deque.insertRight(50);
        deque.displayQueForward();
        deque.displayQueBackward();

        deque.removeLeft();
        deque.removeRight();
        deque.displayQueForward();
    }
}
