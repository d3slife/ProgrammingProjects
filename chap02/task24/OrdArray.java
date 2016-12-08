package chap02.task24;

public class OrdArray {
	
	private long[] a;
	private int elemN;
	
	public OrdArray(int max) {
		a = new long[max];
		elemN = 0;
	}
	
	public void insert(long value) {
		int lowerLimit = 0;
		int upperLimit = elemN - 1;
		int curId = 0;
		while(true) {		
			if(lowerLimit > upperLimit) {
				break;
			} else {
				curId = (lowerLimit + upperLimit) / 2;	
				if(value > a[curId]) {
					lowerLimit = curId + 1;
					curId++;
				} else {
					upperLimit = curId - 1;
				}
			}			
		}
		for(int i = elemN; i > curId; i--) {
			a[i] = a[i - 1];
		}
		a[curId] = value;
		elemN++;
	
		/* Version 1
		if(value > a[curId]) {
			for(int i = elemN; i > curId + 1; i--) {
				a[i] = a[i - 1];
			}
			a[curId + 1] = value;
			elemN++;
		} else {
			for(int i = elemN; i > curId; i--) {
				a[i] = a[i - 1];
			}
			a[curId] = value;
			elemN++;
		}
		*/
	}
	
	public boolean delete(long value) {
		int lowerLimit = 0;
		int upperLimit = elemN - 1;
		int curId = 0;
		while(true) {
			curId = (lowerLimit + upperLimit) / 2;
			if(value == a[curId]) {
				for(int i = curId; i < elemN; i++) {
					a[i] = a[i + 1];
				}
				elemN--;
				return true;
			} else if(lowerLimit > upperLimit) {
				return false;
			}
			if(value > a[curId]) {
				lowerLimit = curId + 1;
			} else {
				upperLimit = curId - 1;
			}
		}
	}
	
	public int find(long value) {
		int lowerLimit = 0;
		int upperLimit = elemN - 1;
		int curId = 0;
		while(true) {
			curId = (lowerLimit + upperLimit) / 2;
			if(value == a[curId]) {
				return curId;
			} else if(lowerLimit > upperLimit) {
				return elemN;
			}
			if(value > a[curId]) {
				lowerLimit = curId + 1;
			} else {
				upperLimit = curId - 1;
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