package chap10.task103;

import java.io.IOException;

public class TreeSort {

    public static void main(String[] args) throws IOException {

        Tree234 tree = new Tree234();
        // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int elemN = 15;
        long[] unsortArray = new long[elemN];

        for(int i = 0; i < elemN; i++) {
            unsortArray[i] = (long)(java.lang.Math.random()*30);
        }

        unsortArray = tree.sortStart(unsortArray);
        for (int i = 0; i < unsortArray.length; i++) {
            System.out.print(unsortArray[i]+ "/");
        }
    }
}
