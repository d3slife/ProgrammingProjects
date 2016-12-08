package chap03.task33;

public class InsertSort {
	
	private long[] a;
	private int elemN;
	
	public InsertSort(int max) {
		a = new long[max];
		elemN = 0;
	}
	
	public void insert(long value) {
		a[elemN] = value;
		elemN++;
	}
	
	public void display() {
		for(int i = 0; i < elemN; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public void insertSort() {
		for(int i = 1; i < elemN; i++) {
			long temp = a[i];
			int j;
			for(j = i; j > 0 && temp < a[j - 1]; j--) {
				a[j] = a[j - 1];
			}
			a[j] = temp;
		}
	}
	
	// Task 3.3;
	public void noDups() {
		int count = 0;
		for(int i = 0; i < elemN; i++) {
			if(a[i] == a[i + 1]) {
				count++;
			} else if(count != 0) {
				System.out.println(count); // Just for visual testing of span to ignore;
				a[i - count] = a[i];
			}
		}
		elemN -= count;
	}
}