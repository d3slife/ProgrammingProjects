package chap11.Task112;

public class HashTableApp {

    public static void main(String[] args) {

        HashTable table = new HashTable(31);

        DataItem item = new DataItem("cool");
        table.insert(item);
        item = new DataItem("bobcat");
        table.insert(item);
        item = new DataItem("argue");
        table.insert(item);
        item = new DataItem("a");
        table.insert(item);
        item = new DataItem("b");
        table.insert(item);

        table.displayTable();
    }
}
