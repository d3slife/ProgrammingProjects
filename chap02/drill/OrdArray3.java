package chap02;

public class OrdArray3 {
	
	private long[] a;
	private int elemN;
	
	public OrdArray3(int max) {
		a = new long[max];
		elemN = 0;
	}
	
	public void insert(long value) {
		int lowerLimit = 0;
		int upperLimit = elemN - 1;
		int curIn;
		
		if(elemN == 0) {
			a[0] = value;
		} else {
			while(true) {
				curIn = (lowerLimit + upperLimit) / 2;
				if(value == a[curIn] || lowerLimit > upperLimit) {
					for(int i = elemN; i > curIn; i--) {
						a[i] = a[i - 1];
					}
					a[curIn + 1] = value;
					elemN++;
					break;
				}
			}
			if(value < a[curIn]) {
				upperLimit = curIn - 1;
			} else {
				lowerLimit = curIn + 1;
			}
		}		
	}

	
	public void display() {
		for(int i = 0; i < elemN; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}