package chap11.Task114;

public class HashTableApp {

    public static void main(String[] args) {

        HashTable table = new HashTable(11);

        table.insert(new DataItem(10));
        table.insert(new DataItem(11));
        table.insert(new DataItem(12));
        table.insert(new DataItem(33));
        table.insert(new DataItem(22));
        table.displayTable();

        table.insert(new DataItem(6));
        table.displayTable();
    }
}
