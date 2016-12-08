package chap11.Task114;

public class HashTable {

    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem;
    private int elemN;
    private DataItem[] rehashedArray;

    public HashTable(int size) {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
        elemN = 0;
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

    public void displayRetable() {
        System.out.print("Table: ");
        for(int j = 0; j < rehashedArray.length; j++) {
            if (rehashedArray[j] != null) {
                System.out.print(hashArray[j].getKey() + " ");
            } else {
                System.out.print("** ");
            }
        }
        System.out.println();
    }

    private int hashFunc(int key) {
        return key % arraySize;
    }

    private int rehashFunc(int key) {
        return key % this.rehashedArray.length;
    }

    public void insert(DataItem item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        // System.out.println("Hash value is: " + hashVal);
        int step = 0;

        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            hashVal += (int) (java.lang.Math.pow(step, 2));
            // System.out.println("Hash value is: " + hashVal);
            step++;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
        this.elemN++;
        if (elemN > 0.5 * arraySize) {
            rehash();
        }
    }

    private void rehash() {
        int newSize = getPrime(this.arraySize * 2);
        System.out.println("New array length is: " + newSize);
        this.rehashedArray = new DataItem[newSize];
        int limit = elemN;

        while(limit > 0) {
            for(int i = 0; i < arraySize; i++) {
                if (hashArray[i] != null && hashArray[i].getKey() != -1) {
                    insertRehash(hashArray[i]);
                    limit--;
                }
            }
        }
        this.hashArray = this.rehashedArray;
        this.arraySize = newSize;
    }

    private void insertRehash(DataItem item) {
        int key = item.getKey();
        int hashVal = rehashFunc(key);
        // System.out.println("Hash value is: " + hashVal);
        int step = 0;

        while (this.rehashedArray[hashVal] != null) {
            hashVal += (int) (java.lang.Math.pow(step, 2));
            // System.out.println("Hash value is: " + hashVal);
            step++;
            hashVal %= this.rehashedArray.length;
        }
        this.rehashedArray[hashVal] = item;
    }

    public DataItem delete(int key) {
        int hashVal = hashFunc(key);
        int step = 0;

        while(hashArray[hashVal] != null) {
            if(hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            hashVal += (int) (java.lang.Math.pow(step, 2));
            step++;
            hashVal %= arraySize;
        }
        this.elemN--;
        return null;
    }

    public DataItem find(int key) {
        int hashVal = hashFunc(key);
        int step = 0;

        while (hashArray[hashVal] != null) {
            if(hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal];
            }
            hashVal += (int) (java.lang.Math.pow(step, 2));
            step++;
            hashVal %= arraySize;
        }
        return null;
    }

    private int getPrime(int min) {
        for(int j = min + 1; true; j++) {
            if (isPrime(j)) {
                return j;
            }
        }
    }

    private boolean isPrime(int n) {
        for(int j = 2; (j * j <= n); j++) {
            if (n % j == 0) {
                return false;
            }
        }
        return true;
    }
}
