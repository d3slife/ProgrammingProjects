package chap11.Task115;

public class HashTableApp {

    public static void main(String[] args) {

        HashTable table = new HashTable(13);

        table.insert(8);
        table.insert(9);
        table.insert(10);
        table.insert(11);
        table.insert(38);
        table.insert(25);
        table.insert(37);
        table.insert(12);

        table.displayTable();
    }
}
