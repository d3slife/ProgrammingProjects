package chap02;

class Array1 {
	private long[] a;
	private int elemN;
			
	public Array1(int max) {
		a = new long[max];
		elemN = 0;
	}

	public boolean find(long searchKey) {
		int i;
		for(i = 0; i < elemN; i++) {
			if(a[i] == searchKey) {
				break;
			}
		}
		if(i == elemN) {
			return false;
		} else {
			return true;
		}
	}
	
	public void insert(long value) {
		a[elemN] = value;
		elemN++;
	}
	
	public boolean delete(long value) {
		int i;
		for(i = 0; i < elemN; i++) {
			if(a[i] == value) {
				break;
			}
		}
		if(i == elemN) {
			return false;
		} else {
			for(int j = i; j < elemN; j++) {
				a[j] = a[j + 1];
			}
			elemN--;
			return true;
		}
	}
	
	public void display() {
		for(int i = 0; i < elemN; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
}