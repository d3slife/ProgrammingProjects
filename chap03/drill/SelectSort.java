package chap03.drill;

public class SelectSort {
	
	private long[] a;
	private int elemN;
	
	public SelectSort(int max) {
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
	
	public void selectSort() {
		for(int i = 0; i < elemN - 1; i++) {
			int min = i;
			for(int j = i; j < elemN; j++) {
				if(a[min] > a[j]) {
					min = j;
				}
			}
			long temp = a[min];
			a[min] = a[i];
			a[i] = temp;
		}
	}
}