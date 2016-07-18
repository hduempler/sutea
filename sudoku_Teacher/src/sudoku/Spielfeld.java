package sudoku;

/*
 * Serialisierung lass ich erst einmal hier heraus. 
 * Dateioperationen sollen später über das DAO laufen
 */

public class Spielfeld{
	public PuzzleArray pa;
	public MyBitSet[] rowVal = new MyBitSet[9];
	public MyBitSet[] colVal = new MyBitSet[9];
	public MyBitSet[] boxVal = new MyBitSet[9];

	public Spielfeld(int spiel) {
		super();
		 pa = new PuzzleArray(spiel);
		for (int i = 0; i < 9; i++) {
			boxVal[i] = new MyBitSet(9);
			colVal[i] = new MyBitSet(9);
			rowVal[i] = new MyBitSet(9);
		} 
		for(int row = 0; row <9 ; row++) {
			for(int col = 0; col <9 ; col++) {
				 setEntry(row, col, pa.feld[row][col].getValue());
			}
		}
	}
	// es gibt freie zu belegende und vom Spiel vorbelegte Felder 
	public boolean setEntry(Integer row, Integer col, Integer val) {
		boolean result = false;
		// if(--.) gibt false wenn auf vorbelegte Felder geschrieben werden soll
		if (pa.feld[row][col].setValue(val)) {
			rowVal[row].checkedSet(val);
			colVal[col].checkedSet(val);
			boxVal[boxValue(row, col)].checkedSet(val);
			result = true;
		} 
		return result;
	}

	private Integer boxValue(Integer row, Integer col) {
		// erzeugt aus row und col einen box wert von 0 - 8
		Integer result = 0;
		result = (row / 3) * 3 + (col / 3);
		return result;
	}
}
