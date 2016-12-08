package chap11.Task112;

public class HashTable {

    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem;

    public HashTable(int size) {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem("del");
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

    public int hashFunc(String key) {
        int hashVal = 0;
        for(int j = 0; j < key.length(); j++) {
            int letter = key.charAt(j) - 96;
            hashVal = (hashVal * 27 + letter) % arraySize;
        }
        return hashVal;
    }

    public void insert(DataItem item) {
        String key = item.getKey();
        int hashVal = hashFunc(key);
        System.out.println("Hash value is: " + hashVal);
        int step = 0;

        while (hashArray[hashVal] != null && !hashArray[hashVal].getKey().equals("del")) {
            hashVal += (int) (java.lang.Math.pow(step, 2));
            System.out.println("Hash value is: " + hashVal);
            step++;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }

    public DataItem delete(String key) {
        int hashVal = hashFunc(key);
        int step = 0;

        while(hashArray[hashVal] != null) {
            if(hashArray[hashVal].getKey().equals(key)) {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            hashVal += (int) (java.lang.Math.pow(step, 2));
            step++;
            hashVal %= arraySize;
        }
        return null;
    }

    public DataItem find(String key) {
        int hashVal = hashFunc(key);
        int step = 0;

        while (hashArray[hashVal] != null) {
            if(hashArray[hashVal].getKey().equals(key)) {
                return hashArray[hashVal];
            }
            hashVal += (int) (java.lang.Math.pow(step, 2));
            step++;
            hashVal %= arraySize;
        }
        return null;
    }
}
