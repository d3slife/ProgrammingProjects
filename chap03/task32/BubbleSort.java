package chap03.task32;

public class BubbleSort {
	
	private long[] a;
	private int elemN;
	
	public BubbleSort(int max) {
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
	
	// Task 3.2;	
	public long getElement(int index) {
		return a[index];
	}
	
	public void bubbleSort() {
		for(int i = elemN - 1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(a[j] > a[j + 1]) {
					long temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}
	
	// Task 3.1;
	public void bubbleSortBi() {
		for(int i = elemN - 1; i > 0; i--) {
			int j;
			for(j = 0; j < i; j++) {
				if(a[j] > a[j + 1]) {
					long temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
			for(int k = j; k > elemN - i; k--) {
				if(a[k] < a[k - 1]) {
					long temp = a[k];
					a[k] = a[k - 1];
					a[k - 1] = temp;
				}
			}
		}
	}
	
	// Task 3.2;
	public long median() {
		this.bubbleSortBi();
		int indexMedian = this.elemN / 2;
		long value = this.getElement(indexMedian);
		return value;
	}
}

















