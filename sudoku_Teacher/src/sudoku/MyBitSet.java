package sudoku;

import java.util.BitSet;

public class MyBitSet extends BitSet {

	private static final long serialVersionUID = 1637341559625599819L;
	Integer isDuplicate = 0;
	 
	public MyBitSet(int nbits) {
		super(nbits);
	}

	public void checkedSet(Integer number) {
		if (get(number) && (number > 0)) {
			isDuplicate = number;
		} else
			set(number); 
	}
 
	@Override
	public String toString() {
		String result = "";
		for (int i=1;i<10; i++){
			result = result + (get(i)==false?"_":i);
		}
		if(isDuplicate > 0) {
			result += isDuplicate;
		}else {
			result += " ";
		}
		
		return result;
	}
	
	

}
