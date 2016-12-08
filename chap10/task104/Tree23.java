package chap10.task104;

public class Tree23 {

    private Node root = new Node();
    private long[] sortArray = new long[3];

    // Task 10.4. This method is OK for a 2-3 tree;
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
                if (curNode.getChild(0) != null) {
                    curNode = getNextChild(curNode, lValue);
                } else {
                    split(curNode, lValue);
                    break;
                }
            } else if (curNode.isLeaf()) {
                curNode.insertItem(tempItem);
                break;
            } else {
                curNode = getNextChild(curNode, lValue);
            }
        }
    }

    public Node split(Node thisNode, long thisValue) {

        if (thisNode == root) {
            Node newRight = new Node();
            root = new Node();
            root.connectChild(0, thisNode);
            root.connectChild(1, newRight);

            if (thisValue > thisNode.getItem(1).lData) {
                newRight.insertItem(new DataItem(thisValue));
                DataItem temp = thisNode.removeItem();
                root.insertItem(temp);
            } else if (thisValue > thisNode.getItem(0).lData) {
                DataItem temp = thisNode.removeItem();
                newRight.insertItem(temp);
                root.insertItem(new DataItem(thisValue));
            } else {
                DataItem temp = thisNode.removeItem();
                newRight.insertItem(temp);
                temp = thisNode.removeItem();
                root.insertItem(temp);
                thisNode.insertItem(new DataItem(thisValue));
            }

            return newRight;

        } else if (thisNode.getParent().isFull()) {                     // Code for task 10.5

            Node newRight = new Node();
            Node topParent;
            // thisNode.getParent().connectChild(1, newRight);

            if (thisValue > thisNode.getItem(1).lData) {
                newRight.insertItem(new DataItem(thisValue));
                DataItem temp = thisNode.removeItem();
                topParent = split(thisNode.getParent(), temp.lData);
                topParent.connectChild(0, thisNode);
                topParent.connectChild(1, newRight);
            } else if (thisValue > thisNode.getItem(0).lData) {
                DataItem temp = thisNode.removeItem();
                newRight.insertItem(temp);
                topParent = split(thisNode.getParent(), thisValue);
                topParent.connectChild(0, thisNode);
                topParent.connectChild(1, newRight);
            } else {
                DataItem temp = thisNode.removeItem();
                newRight.insertItem(temp);
                temp = thisNode.removeItem();
                topParent = split(thisNode.getParent(), temp.lData);
                thisNode.insertItem(new DataItem(thisValue));
                topParent.connectChild(0, thisNode);
                topParent.connectChild(1, newRight);
            }

            return newRight;

        } else {

            Node newRight = new Node();
            thisNode.getParent().connectChild(2, newRight);

            if (thisValue > thisNode.getItem(1).lData) {
                newRight.insertItem(new DataItem(thisValue));
                DataItem temp = thisNode.removeItem();
                thisNode.getParent().insertItem(temp);
            } else if (thisValue > thisNode.getItem(0).lData) {
                DataItem temp = thisNode.removeItem();
                newRight.insertItem(temp);
                thisNode.getParent().insertItem(new DataItem(thisValue));
            } else {
                DataItem temp = thisNode.removeItem();
                newRight.insertItem(temp);
                temp = thisNode.removeItem();
                thisNode.getParent().insertItem(temp);
                thisNode.insertItem(new DataItem(thisValue));
            }

            return newRight;
        }
    }

    // Task 10.4 This method is OK for a 2-3 tree;
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

    // Task 10.4 This method is OK for a 2-3 tree;
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
}
