package chap03.task35;

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
		for(int i = 0; i < elemN - 1; i++) {
			for(int j = i + 1; j < elemN; j++) {
				if(a[i] == a[j]) {
					a[j] = -1;
				}
			}
		}
		int totalCount = 1;
		for(int i = 0; i < elemN - 1; i++) {
			if(a[i] == -1) {
				int count = 1;
				for(int j = i + 1; j < elemN; j++) {
					if(a[j] == -1) {
						totalCount++;
						count++;
					} else {
						break;
					}
				}
				a[i] = a[i + count];
			}
		}
		elemN -= totalCount;
	}
	
	// Task 3.4;
	public void oddEvenSort() {
		for(int j = 0; j < elemN - 1; j++) {
			for(int i = 1; i < elemN - 1; i += 2) {
				if(a[i] > a[i + 1]) {
					long temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
				}
			}
			for(int i = 0; i < elemN - 1; i += 2) {
				if(a[i] > a[i + 1]) {
					long temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
				}
			}
		}		
	}
	
	// Task 3.5;
	public void insertSort2() {
		int i;
		int copy = 0;
		int comparison = 0;
		for(i = 1; i < elemN; i++) {
			long temp = a[i];
			copy++;
			int j;
			for(j = i; j > 0; j--) {
				comparison++;
				if(temp < a[j - 1]) {
					a[j] = a[j - 1];
					copy++;
				} else {
					break;
				}
			}
			a[j] = temp;
			copy++;
		}
		System.out.println("Numbers of copies: " + copy);
		System.out.println("Numbers of comparisons: " + comparison);
	}	
}




















