package chap03.drill;

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
}