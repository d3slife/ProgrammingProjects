package chap11.Task113;

public class HashTableApp {

    public static void main(String[] args) {

        HashTable table = new HashTable(13);

        table.insert(new DataItem(2222));
        table.insert(new DataItem(1111));
        table.insert(new DataItem(2204));

        table.displayTable();
    }
}
