package chap12.task124;

public class PriorityQueue {

    private Tree tree;

    public PriorityQueue() {
        tree = new Tree();
    }

    public void insert(int key) {
        tree.insert(key);
    }

    public int removeMax() {
        return tree.removeMax();
    }

    public boolean isEmpty() {
        return tree.isEmpty();
    }

    public void displayQueue() {
        tree.traverse(4);
    }

    public void displayAsTree() {
        tree.displayTree();
    }
}
