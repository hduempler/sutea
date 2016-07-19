package sudoku;

import java.util.BitSet;

public class MyBitSet extends BitSet {

	private static final long serialVersionUID = 1637341559625599819L;
	Integer isDuplicate = 0;
	
	public MyBitSet(int nbits) {
		super(nbits);
	}

	public void checkedSet(Integer number) {
		if (this.get(number)) {
			isDuplicate = number;
		} else
			this.set(number);
	}

	@Override
	public String toString() {
		String result = "";
		for (int i=1;i<10; i++){
			result = result + (get(i)==false?"_":i);
		}
		return result;
	}
	
	

}
