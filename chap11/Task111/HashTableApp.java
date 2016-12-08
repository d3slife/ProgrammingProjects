package chap11.Task111;

public class HashTableApp {

    public static void main(String[] args) {

        HashTable table = new HashTable(11);

        DataItem temp = new DataItem(11);
        table.insert(temp);
        temp = new DataItem(33);
        table.insert(temp);
        temp = new DataItem(44);
        table.insert(temp);

        table.displayTable();

        table.delete(33);
        table.displayTable();
    }
}
