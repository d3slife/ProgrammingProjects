package chap02;

public class Array2 {
	
	private long[] a;
	private int elemN;
	
	public Array2(int max) {
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
	
	public boolean find(long value) {
		int i;
		for(i = 0; i < elemN; i++) {
			if(value == a[i]) {
				break;
			}
		}
		if(elemN == i) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean delete(long value) {
		int i;
		for(i = 0; i < elemN; i++) {
			if(value == a[i]) {
				break;
			}
		}
		if(elemN == i) {
			return false;
		} else {
			for(int j = i; j < elemN; j++) {
				a[j] = a[j + 1];
			}
			elemN--;
			return true;
		}
	}
}