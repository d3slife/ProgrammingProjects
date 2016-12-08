package chap13.task135;

public class StackX {

    private Knight[] st;
    private int top;
    private int size;

    public StackX(int stackSize) {
        st = new Knight[stackSize];
        top = -1;
        size = stackSize;
    }

    public void push(Knight j) {
        st[++top] = j;
    }

    public Knight pop() {
        return st[top--];
    }

    public Knight peek() {
        return st[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return top == size - 1;
    }
}
