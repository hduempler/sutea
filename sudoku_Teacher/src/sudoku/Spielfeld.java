package sudoku;

/*
 * Serialisierung lass ich erst einmal hier heraus. 
 * Dateioperationen sollen später über das DAO laufen
 */

public class Spielfeld{
	private SudokuEntry[][] field = new SudokuEntry[9][9];
	private MyBitSet[] rowVal = new MyBitSet[9];
	private MyBitSet[] colVal = new MyBitSet[9];
	private MyBitSet[] boxVal = new MyBitSet[9];

	public Spielfeld() {
		super();
		for (int i = 0; i < 9; i++) {
			boxVal[i] = new MyBitSet(9);
			colVal[i] = new MyBitSet(9);
			rowVal[i] = new MyBitSet(9);
		}
	}
	// es gibt freie zu belegende und vom Spiel vorbelegte Felder 
	public boolean setEntry(Integer row, Integer col, Integer val) {
		boolean result = false;
		// if(--.)=false wenn auf vorbelegte Felder geschrieben werden soll
		if (field[row][col].setValue(val)) {
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
