package chap10.task104;

public class Node {

    private static final int ORDER = 3;
    private int numItems;
    private Node parent;
    private Node childArray[] = new Node[ORDER];
    private DataItem itemArray[] = new DataItem[ORDER - 1];

    public void connectChild(int childNum, Node child) {
        childArray[childNum] = child;
        if (child != null) {
            child.parent = this;
        }
    }

    public Node disconnectChild(int childNum) {
        Node tempNode = childArray[childNum];
        childArray[childNum] = null;
        return tempNode;
    }

    public Node getChild(int childNum) {
        return childArray[childNum];
    }

    public Node getParent() {
        return this.parent;
    }

    public boolean isLeaf() {
        return (childArray[0] == null);
    }

    public int getNumItems() {
        return numItems;
    }

    public DataItem getItem(int index) {
        return this.itemArray[index];
    }

    public boolean isFull() {
        return (this.numItems == ORDER - 1);
    }

    public int findItem(long key) {
        for(int j = 0; j < ORDER - 1; j++) {
            if (itemArray[j] == null) {
                break;
            } else if (itemArray[j].lData == key) {
                return j;
            }
        }
        return -1;
    }

    public int insertItem(DataItem newItem) {
        numItems++;
        long newKey = newItem.lData;

        for(int j = ORDER - 2; j >= 0; j--) {
            if (itemArray[j] == null) {
                continue;
            } else {
                long itsKey = itemArray[j].lData;
                if (newKey < itsKey) {
                    itemArray[j + 1] = itemArray[j];
                } else {
                    itemArray[j + 1] = newItem;
                    return j + 1;
                }
            }
        }
        itemArray[0] = newItem;
        return 0;
    }

    public DataItem removeItem() {
        DataItem temp = itemArray[numItems - 1];
        itemArray[numItems - 1] = null;
        numItems--;
        return temp;
    }

    public void displayNode() {
        for(int j = 0; j < numItems; j++) {
            itemArray[j].displayItem();
        }
        System.out.println("/");
    }
}
