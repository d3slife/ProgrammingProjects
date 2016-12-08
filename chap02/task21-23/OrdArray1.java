package chap02;

public class OrdArray1 {
	
	private long[] a;
	private int elemN;
	
	public OrdArray1(int max) {
		a = new long[max];
		elemN = 0;
	}
	
	public int size() {
		return elemN;
	}
	
	public void display() {
		for(int i = 0; i < elemN; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public int find(long value) {
		int lowerLimit = 0;
		int upperLimit = elemN - 1;
		int curI;
		
		while(true) {
			curI = (lowerLimit + upperLimit) / 2;
			if(value == a[curI]){
				return curI;
			} else if(lowerLimit > upperLimit) {
				return elemN;
			} else if(a[curI] > value) {
				upperLimit = curI - 1;
			} else {
				lowerLimit = curI + 1;
			}
		}
	}
	
	public void insert(long value) {
		int i;
		for(i = 0; i < elemN; i++) {
			if(value < a[i]) {
				break;
			}
		}
		for(int j = elemN; j > i; j--) {
			a[j] = a[j - 1];
		}
		a[i] = value;
		elemN++;
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
		}
		elemN--;
		return true;
	}
}




























