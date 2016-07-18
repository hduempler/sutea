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

}
