package chap10.task102;

public class Tree234 {

    private Node root = new Node();

    public int find(long key) {
        Node curNode = this.root;
        int childNumber;

        while(true) {
            childNumber = curNode.findItem(key);
            if (childNumber != -1) {
                return childNumber;
            } else if (curNode.isLeaf()) {
                return -1;
            } else {
                curNode = getNextChild(curNode, key);
            }
        }
    }

    public void insert(long lValue) {
        Node curNode = root;
        DataItem tempItem = new DataItem(lValue);

        while(true) {
            if (curNode.isFull()) {
                split(curNode);
                curNode = curNode.getParent();
                curNode = getNextChild(curNode, lValue);
            } else if (curNode.isLeaf()) {
                break;
            } else {
                curNode = getNextChild(curNode, lValue);
            }
        }
        curNode.insertItem(tempItem);
    }

    public void split(Node thisNode) {
        DataItem itemB, itemC;
        Node parent, child2, child3;
        int itemIndex;

        itemC = thisNode.removeItem();
        itemB = thisNode.removeItem();
        child2 = thisNode.disconnectChild(2);
        child3 = thisNode.disconnectChild(3);

        Node newRight = new Node();

        if (thisNode == root) {
            root = new Node();
            parent = root;
            root.connectChild(0, thisNode);
        } else {
            parent = thisNode.getParent();
        }

        itemIndex = parent.insertItem(itemB);
        int n = parent.getNumItems();

        for(int j = n - 1; j > itemIndex; j--) {
            Node temp = parent.disconnectChild(j);
            parent.connectChild(j + 1, temp);
        }

        parent.connectChild(itemIndex + 1, newRight);

        newRight.insertItem(itemC);
        newRight.connectChild(0, child2);
        newRight.connectChild(1, child3);
    }

    public Node getNextChild(Node theNode, long theValue) {
        int j;
        int numItems = theNode.getNumItems();

        for(j = 0; j < numItems; j++) {
            if (theValue < theNode.getItem(j).lData) {
                return theNode.getChild(j);
            }
        }
        return theNode.getChild(j);
    }

    public void displayTree() {
        recDisplayTree(this.root, 0, 0);
    }

    private void recDisplayTree(Node thisNode, int level, int childNumber) {
        System.out.print("level = " + level + " child = " + childNumber + " ");
        thisNode.displayNode();

        int numItems = thisNode.getNumItems();
        for(int j = 0; j < numItems + 1; j++) {
            Node nextNode = thisNode.getChild(j);
            if (nextNode != null) {
                recDisplayTree(nextNode, level + 1, j);
            } else {
                return;
            }
        }
    }

    // Task 10.1
    public long getMin() {
        Node curNode = this.root;
        long minValue;

        while(true) {
            if (!curNode.isLeaf()) {
                curNode = curNode.getChild(0);
            } else if (curNode.getNumItems() == 0) {
                minValue = -1;
                break;
            } else {
                minValue = curNode.getItem(0).lData;
                break;
            }
        }

        return minValue;
    }

    // Task 10.2
    public void inorderStart() {
        recInorder(this.root);
        System.out.print("/");
    }

    private void recInorder(Node curNode) {

        if (curNode.isLeaf()) {
            curNode.displayNode();
        } else {
            for(int i = 0; i <= curNode.getNumItems(); i++) {
                recInorder(curNode.getChild(i));
                if (i < curNode.getNumItems()) {
                    curNode.getItem(i).displayItem();
                }
            }
        }
    }
}
