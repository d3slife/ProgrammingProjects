package chap06.drill;

// This class isn't the same as is in Lafore's book
// Just was trying to remember the algorithm and
// type it for better understanding;

public class RecursiveBinarySearch {

    private int[] array;

    public void find(int number) {
        int lowerLimit = 0;
        int upperLimit = array.length - 1;
        int result = recFind(number, lowerLimit, upperLimit);
        System.out.println("So final result is: ");
    }

    public int recFind(int number, int lowerLimit, int upperLimit) {
        int curNumber = (lowerLimit + upperLimit) / 2;
        if (number == array[curNumber]) {
            return number;
        } else if (lowerLimit > upperLimit) {
            return array.length;
        }
        if (number > array[curNumber]) {
            return recFind(number, curNumber + 1, upperLimit);
        } else {
            return recFind(number, lowerLimit, upperLimit + 1);
        }
    }
}
