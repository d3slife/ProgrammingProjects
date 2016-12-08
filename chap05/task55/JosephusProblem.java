package chap05.task55;

public class JosephusProblem {

    private int peopleNumber;
    private int countOff;
    private int countStart;
    public SinglyLinkedList list;

    public JosephusProblem(int peopleNumber, int countOff, int countStart) {
        this.peopleNumber = peopleNumber;
        this.countOff = countOff;
        this.countStart = countStart;
        list = new SinglyLinkedList();
    }

    public void countingOff() {
        for (int i = 1; i <= this.peopleNumber; i++) {
            list.insert(i);
        }
        System.out.println("These are the values for Josephus Problem:");
        list.displayList();


        while (true) {
            for (int i = 0; i < this.countOff; i++) {
                list.step();
            }

            int number = list.delete();
            if (number != 0) {
                continue;
            } else {
                break;
            }
        }
    }
}
