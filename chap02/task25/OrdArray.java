package chap02.task25;

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
	
	public OrdArray merge(OrdArray array1, OrdArray array2) {
		OrdArray array3 = new OrdArray(100);
		int size1 = array1.size();
		int size2 = array2.size();
		int j = 0;
		int k = 0;
		
		if(size1 < size2) {
			for(int i = 0; i < size1;) {
				long elem1 = array1.getElement(j);
				long elem2 = array2.getElement(k);
				if(elem1 < elem2) {
					array3.insert(elem1);
					i++;
					j++;
				} else {
					array3.insert(elem2);
					k++;
				}
			}
			for(; k < size2; k++) {
				long elem2 = array2.getElement(k);
				array3.insert(elem2);
			}
		} else {
			for(int i = 0; i < size2;) {
				long elem1 = array1.getElement(j);
				long elem2 = array2.getElement(k);
				if(elem1 < elem2) {
					array3.insert(elem1);
					j++;
				} else {
					array3.insert(elem2);
					i++;
					k++;
				}
			}
			for(; j < size1; j++) {
				long elem1 = array1.getElement(j);
				array3.insert(elem1);
			}
		}
		return array3;
	}
	
	public int size() {
		return elemN;
	}
	
	public long getElement(int index) {
		return a[index];
	}
	
	public void display() {
		for(int i = 0; i < elemN; i++) {
			System.out.println("element " + i + " = " + a[i]);
		}
		System.out.println();
	}
}