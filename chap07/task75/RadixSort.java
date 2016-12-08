package chap07.task75;

public class RadixSort {

    private LinkedList[] list;
    private int[] array;

    public RadixSort(int max) {
        this.list = new LinkedList[10];
        this.array = new int[max];
        this.fillLists();
        this.fillArray();
    }

    private void fillLists() {
        LinkedList zeroList = new LinkedList();
        LinkedList oneList = new LinkedList();
        LinkedList twoList = new LinkedList();
        LinkedList threeList = new LinkedList();
        LinkedList fourList = new LinkedList();
        LinkedList fiveList = new LinkedList();
        LinkedList sixList = new LinkedList();
        LinkedList sevenList = new LinkedList();
        LinkedList eightList = new LinkedList();
        LinkedList nineList = new LinkedList();

        list[0] = zeroList;
        list[1] = oneList;
        list[2] = twoList;
        list[3] = threeList;
        list[4] = fourList;
        list[5] = fiveList;
        list[6] = sixList;
        list[7] = sevenList;
        list[8] = eightList;
        list[9] = nineList;
    }

    private void fillArray() {
        for(int i = 0; i < array.length; i++) {
            int n = (int)(java.lang.Math.random() * 1000);
            array[i] = n;
        }
    }

    private void radixSort() {

        int n = 1;
        int zeros = 0;

        while(true) {
            for(int i = 0; i < array.length; i++) {
                // System.out.println("Number: " + array[i] + "; n: " + n);
                int number = (array[i] / n) % 10;
                switch(number) {
                    case 0 : list[0].insertLast(array[i]);
                        zeros++;
                        break;
                    case 1 : list[1].insertLast(array[i]);
                        break;
                    case 2 : list[2].insertLast(array[i]);
                        break;
                    case 3 : list[3].insertLast(array[i]);
                        break;
                    case 4 : list[4].insertLast(array[i]);
                        break;
                    case 5 : list[5].insertLast(array[i]);
                        break;
                    case 6 : list[6].insertLast(array[i]);
                        break;
                    case 7 : list[7].insertLast(array[i]);
                        break;
                    case 8 : list[8].insertLast(array[i]);
                        break;
                    case 9 : list[9].insertLast(array[i]);
                        break;
                    default :
                        System.out.println("Impossible to reach!");
                        break;
                }
            }

            if (zeros == array.length) {
                break;
            } else {
                zeros = 0;
            }

            int i = 0;
            int j = 0;
            while(true) {
                if(!list[i].isEmpty()) {
                    array[j] = list[i].deleteFirst().iValue;
                    j++;
                    // System.out.println("Inserted at array index " + (j - 1) + "; and list number " + i);
                } else if (i < 9) {
                    i++;
                } else {
                    break;
                }
            }
            this.displayArray();
            n *= 10;
        }
    }

    private void displayArray() {
        System.out.print("Array: ");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        RadixSort radix = new RadixSort(10);
        radix.displayArray();
        radix.radixSort();
    }
}
