package chap10.task101;

public class DataItem {

    public long lData;

    public DataItem(long lData) {
        this.lData = lData;
    }

    public void displayItem() {
        System.out.print("/" + lData);
    }
}
