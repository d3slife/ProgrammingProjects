package chap12.task125;

public class TreeApp {

    public static void main(String[] args) {

        Tree tree = new Tree();

        tree.insert(10);
        tree.insert(11);
        tree.insert(12);
        tree.insert(13);
        tree.insert(9);
        tree.insert(20);
        tree.insert(44);
        tree.insert(55);
        tree.insert(66);
        tree.insert(77);

        tree.remove();

        tree.displayTree();
    }
}
