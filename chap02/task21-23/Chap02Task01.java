package chap02;

public class Chap02Task01 {
	
	private long[] a;
	private int elemN;
	
	public Chap02Task01(int max) {
		a = new long[max];
		elemN = 0;
	}
	
	public void insert(long value) {
		a[elemN] = value;
		elemN++;
	}
	
	public boolean delete(long value) {
		int i;
		for(i = 0; i < elemN; i++) {
			if(value == a[i]) {
				break;
			}
		}
		if(elemN == i){
			return false;
		} else {
			for(int j = i; j < elemN; j++) {
				a[j] = a[j + 1];
			}
			elemN--;
			return true;
		}
	}
	
	public int find(long value) {
		int i;
		for(i = 0; i < elemN; i++) {
			if(value == a[i]) {
				break;
			}
		}
		if(elemN == i) {
			return elemN;
		} else {
			return i;
		}
	}
	
	public void display() {
		for(int i = 0; i < elemN; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();	
	}
	
	public int size() {
		return elemN;
	}
	
	public long getMax() {
		if(elemN > 0) {
			long max = a[0];
			for(int i = 0; i < elemN; i++) {
				if(max < a[i]) {
					max = a[i];
				}
			}
			return max;
		} else {
			return -1;
		}	
	}
	
	public long removeMax() {
		if(elemN > 0) {
			long max = a[0];
			int indexM = 0;
			for(int i = 0; i < elemN; i++) {
				if(max < a[i]) {
					max = a[i];
					indexM = i;
				}
			}
			for(int j = indexM; j < elemN; j++) {
				a[j] = a[j + 1];
			}
			elemN--;
			System.out.println("Element " + max + " has been removed");
			return max;
		} else {
			return -1;
		}	
	}
}















