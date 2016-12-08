package chap02;

public class OrdArray2 {
	
	private long[] a;
	private int elemN;
	
	public OrdArray2(int max) {
		a = new long[max];
		elemN = 0;
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
	}
	
	public void display() {
		for(int i = 0; i < elemN; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}