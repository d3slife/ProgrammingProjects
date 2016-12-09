package chap14.task144;

public class Anagram {

    private int size;
    private int count;
    private int height;
    private char[] arrChar;
    private char[][] matrixChar;

    public Anagram(char[] arrChar) {
        this.arrChar = arrChar;
        size = arrChar.length;
        count = 0;

        height = 1;
        for(int i = 1; i <= size; i++) {
            height *= i;
        }
        matrixChar = new char[height][size];

        doAnagram(size);
    }

    public void doAnagram(int newSize) {
        if (newSize == 1) {                     // If our size refers to only 1 letter, we immediately return;
            return;
        }
        for (int j = 0; j < newSize; j++) {     // 3
            doAnagram(newSize - 1);             //
            if (newSize == 2) {
                addWordToArr();                  // For the first time it displays word in its initial state;
            }
            rotate(newSize);                    //
        }
    }

    public void rotate(int newSize) {    // 2
        int j;
        int position = size - newSize;          // 1
        char temp = arrChar[position];          // Char at 1 pos --> temp
        for (j = position + 1; j < size; j++) { // Shift chars
            arrChar[j - 1] = arrChar[j];        //
        }                                       //
        arrChar[j - 1] = temp;                  // Return temp to last pos
    }

    public void addWordToArr() {
        for (int j = 0; j < size; j++) {
            matrixChar[height - 1][j] = arrChar[j];
        }
        height--;
    }

    public char[][] getMatrixChar() {
        return matrixChar;
    }
}
