package chap11.Task113;

public class HashTable {

    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem;
    private int moduloVal;

    public HashTable(int size) {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
        moduloVal = 10;
    }

    private void getModuloVal(int arraySize) {
        while(arraySize > 10) {
            this.moduloVal *= 10;
            arraySize /= 10;
        }
    }

    public void displayTable() {
        System.out.print("Table: ");
        for(int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null) {
                System.out.print(hashArray[j].getKey() + " ");
            } else {
                System.out.print("** ");
            }
        }
        System.out.println();
    }

    /*
    public int hashFunc(int key) {
        return key % arraySize;
    }
    */

    // Task 11.3 - Folding;
    public int hashFunc(int key) {
        int finalKey = 0;
        while(key > 0) {
            finalKey += key % this.moduloVal;
            key /= this.moduloVal;
        }
        // System.out.println("Final key is: " + finalKey % moduloVal);
        return finalKey % moduloVal;
    }

    public void insert(DataItem item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        // System.out.println("Hash value is: " + hashVal);

        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            hashVal++;
            // System.out.println("Hash value is: " + hashVal);
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }

    public DataItem delete(int key) {
        int hashVal = hashFunc(key);

        while(hashArray[hashVal] != null) {
            if(hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            hashVal++;
            hashVal %= arraySize;
        }
        return null;
    }

    public DataItem find(int key) {
        int hashVal = hashFunc(key);

        while (hashArray[hashVal] != null) {
            if(hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal];
            }
            hashVal++;
            hashVal %= arraySize;
        }
        return null;
    }
}
