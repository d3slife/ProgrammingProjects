package chap11.Task115;

public class HashTable {

    private Tree[] hashArray;
    private int arraySize;

    public HashTable(int size) {
        arraySize = size;
        hashArray = new Tree[arraySize];
        for(int j = 0; j < arraySize; j++) {
            hashArray[j] = new Tree();
        }
    }

    public void displayTable() {
        for(int j = 0; j < arraySize; j++) {
            Node current = hashArray[j].getRoot();
            if (current == null) {
                System.out.println("Empty tree");
            } else {
                hashArray[j].inOrder(current);
                System.out.println();
            }
        }
    }

    private int hashFunc(int key) {
        return key % arraySize;
    }

    public void insert(int iValue) {
        int hashVal = hashFunc(iValue);
        Node duplicate = find(iValue);

        if (duplicate == null) {
            hashArray[hashVal].insert(iValue);
        } else {
            System.out.println("Duplicates are forbidden.");
        }
    }

    public Node find(int iValue) {
        int hashVal = hashFunc(iValue);
        if (hashArray[hashVal].getRoot() != null) {
            return hashArray[hashVal].find(iValue);
        } else {
            return null;
        }
    }
}
