package chap12.task125;

import java.util.Stack;

public class Tree {

    private Node root;
    private int elemN;

    public Tree() {
        root = null;
        elemN = 0;
    }

    // Don't have to change the method from binary search tree;
    public boolean isEmpty() {
        return (root == null);
    }

    // Priority queue doesn't imply implementing find method. Let's make it private;
    private Node find(int key) {
        Node current = root;
        while(current.iData != key) {
            if (key < current.iData) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert(int key) {
        int[] currentPath = generatePath(++elemN);
        Node parentNode = this.root;
        Node currentNode = this.root;

        if(isEmpty()) {
            this.root = new Node(null, key);
        } else {
            for (int i = currentPath.length - 2; i >= 1; i--) {
                if (currentPath[i] == 1) {
                    parentNode = currentNode;
                    currentNode = currentNode.rightChild;
                } else {
                    parentNode = currentNode;
                    currentNode = currentNode.leftChild;
                }
            }

            Node newNode = new Node(currentNode, key);
            if (currentPath[0] == 1) {
                currentNode.rightChild = newNode;
            } else {
                currentNode.leftChild = newNode;
            }
            trickleUp(newNode);
        }
    }

    public int remove() {
        int temp = root.iData;
        int current;
        Node currentNode = root;

        if (elemN == 1) {
            root = null;
            elemN--;
        } else {
            int[] currentPath = generatePath(elemN);
            elemN--;
            for(int i = currentPath.length - 2; i >= 1; i--) {
                if (currentPath[i] == 1) {
                    currentNode = currentNode.rightChild;
                } else {
                    currentNode = currentNode.leftChild;
                }
            }

            if (currentPath[0] == 1) {
                current = currentNode.rightChild.iData;
                currentNode.rightChild = null;
            } else {
                current = currentNode.leftChild.iData;
                currentNode.leftChild = null;
            }
            this.root.iData = current;
            if (elemN > 1) {
                trickleDown(root);
            }
        }

        return temp;
    }

    public void trickleUp(Node newNode) {
        int nodeValue = newNode.iData;

        while(newNode.parent != null && nodeValue > newNode.parent.iData) {
            newNode.iData = newNode.parent.iData;
            newNode = newNode.parent;
        }
        newNode.iData = nodeValue;
    }

    /*
    public void trickleDown(Node newNode) {
        int nodeValue = newNode.iData;
        Node largerChild = newNode;

        while(largerChild.rightChild != null || largerChild.leftChild != null) {
            if (largerChild.leftChild != null && largerChild.rightChild != null) {
                if (largerChild.leftChild.iData > largerChild.rightChild.iData) {
                    largerChild = largerChild.leftChild;
                } else {
                    largerChild = largerChild.leftChild;
                }
            } else if (largerChild.leftChild != null) {
                largerChild = largerChild.leftChild;
            } else {
                largerChild = largerChild.rightChild;
            }

            if (nodeValue > largerChild.iData) {
                break;
            }
            largerChild.parent.iData = largerChild.iData;
        }
        largerChild.parent.iData = nodeValue;
    }
    */

    public void trickleDown(Node newNode) {
        int tempValue = newNode.iData;

        while(newNode.leftChild != null || newNode.rightChild != null) {

            if(newNode.leftChild != null && newNode.rightChild != null) {
                if(newNode.leftChild.iData > newNode.rightChild.iData) {
                    newNode = newNode.leftChild;
                } else {
                    newNode = newNode.rightChild;
                }
            } else if (newNode.rightChild != null) {
                newNode = newNode.rightChild;
            } else {
                newNode = newNode.leftChild;
            }

            if(newNode.iData < tempValue) {
                break;
            } else {
                newNode.parent.iData = newNode.iData;
            }
        }

        if(newNode.leftChild == null && newNode.rightChild == null) {
            newNode.iData = tempValue; // this is ok if while breaks;
        } else {
            newNode.parent.iData = tempValue;
        }

    }

    public void change(int elemN, int newValue) {
        Node currentNode = root;
        int[] currentPath = generatePath(elemN);

        for(int i = currentPath.length - 2; i >= 0; i--) {
            if (currentPath[i] == 1) {
                currentNode = root.rightChild;
            } else {
                currentNode = root.leftChild;
            }
        }
        int temp = currentNode.iData;
        currentNode.iData = newValue;
        if (temp < newValue) {
            trickleUp(currentNode);
        } else {
            trickleDown(currentNode);
        }
    }

    private int[] generatePath(int nodeNumb) {
        int[] currentPath;
        double tempValue = (java.lang.Math.log(elemN + 1) / java.lang.Math.log(2));

        if (tempValue % 1 != 0) {
            currentPath = new int[(int) (tempValue + 1)];
        } else {
            currentPath = new int[(int) tempValue];
        }
        int j = 0;
        while(nodeNumb >= 1) {
            currentPath[j++] = nodeNumb % 2;
            nodeNumb /= 2;
        }
        return currentPath;
    }


    // Only case 4 satisfies our requirements;
    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1 :
                System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2 :
                System.out.print("\nInorder traversal: ");
                inOrder(root);
                break;
            case 3 :
                System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
            case 4 :
                System.out.print("\nPriority queue: ");
                displayAsQueue(root);
                break;
        }
        System.out.println();
    }

    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.iData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData + " ");
            inOrder(localRoot.rightChild);
        }
    }

    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.iData + " ");
        }
    }

    private void displayAsQueue(Node localRoot) {
        if (localRoot != null) {
            displayAsQueue(localRoot.rightChild);
            System.out.print(localRoot.iData + " ");
            displayAsQueue(localRoot.leftChild);
        }
    }

    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < nBlanks; j++) {
                System.out.print(" ");
            }

            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if (temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }

                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());
            }
        }
    }
}
