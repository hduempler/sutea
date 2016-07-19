package sudoku;

/*
 * Serialisierung lass ich erst einmal hier heraus. 
 * Dateioperationen sollen später über das DAO laufen
 */

public class Spielfeld {
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
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				setEntry(row, col, pa.feld[row][col].getValue());
			}
		}
		setSudokuBitSets();
	}

	public void showMyBitSet() {
		for (int i = 0; i < 9; i++) {
			System.out.print("Die Box[" + i + "]: " + boxVal[i] + "\t");
			System.out.print("Die Reihe[" + i + "]: " + rowVal[i] + "\t");
			System.out.print("Die Spalte[" + i + "]: " + colVal[i]);
			System.out.println();
		}
		System.out.println();
	}

	public void setSudokuBitSets() {
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				rowVal[row].checkedSet(pa.feld[row][col].getValue());
				colVal[row].checkedSet(pa.feld[col][row].getValue());
				boxVal[boxValue(row, col)].checkedSet(pa.feld[row][col].getValue());
			}
		}
	}

	// es gibt frei zu belegende und vom Spiel vorbelegte Felder
	public boolean setEntry(Integer row, Integer col, Integer val) {
		boolean result = false;
		// if(--.) gibt false wenn auf vorbelegte Felder geschrieben werden soll
		if (pa.feld[row][col].setValue(val)) {
			rowVal[row].checkedSet(val);
			colVal[col].checkedSet(val);
			boxVal[boxValue(row, col)].checkedSet(val);
			result = true;
		}
		setSudokuBitSets();
		return result;
	}

	private static Integer boxValue(Integer row, Integer col) {
		// erzeugt aus row und col einen box wert von 0 - 8
		Integer result = 0;
		result = (row / 3) * 3 + (col / 3);
		return result;
	}
}
