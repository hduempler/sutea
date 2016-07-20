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
	private String buchstabe = "abcdefghi";

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
				setEntry(row, col, pa.feld[row][col].getValue(), false);
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
		/*
		 * die MyBitSets sind nur für die Auswertung, 
		 * sie werden hier vor jedem Aufruf erst einmal gelöscht um 
		 * Falschmeldungen bei Dopplungen zu vermeiden
		 * ob das alles wirklich notwendig ist?
		 * Wenn ich mir die Daten auf deren Grundlage die BitSeets erzeugt werden 
		 * genauer anschaue sind eigentlich keine Doppelungen möglich 
		 * Diese können aber entstehen wenn ich versuche ein Feld manuell zu setzen
		 */
		
		for (int i = 0; i < 9; i++) {
			rowVal[i].set(0, 10, false);
			colVal[i].set(0, 10, false);
			boxVal[i].set(0, 10, false);
		}
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				rowVal[row].checkedSet(pa.feld[row][col].getValue());
				colVal[row].checkedSet(pa.feld[col][row].getValue());
				boxVal[boxValue(row, col)].checkedSet(pa.feld[row][col].getValue());
			}
		}
	}

	public boolean setEntry(Integer row, Integer col, Integer val, boolean b) {
		// es gibt frei zu belegende und vom Spiel vorbelegte Felder
		boolean result = false;
		// if(--.) gibt false wenn auf vorbelegte Felder geschrieben werden soll
		if (pa.feld[row][col].setValue(val)) {
			rowVal[row].checkedSet(val);
			colVal[col].checkedSet(val);
			boxVal[boxValue(row, col)].checkedSet(val);
			result = true;
		}
		if(b && result) {
			System.out.println("In Reihe[" + buchstabe.charAt(row) + "],Spalte[" + (col+1) +"] wurde eine " + val + " gesetzt.\n");
			einfacheAusgabe();
		}	else if(b) {
			System.out.println("Fehler beim Versuch in  Reihe[" + buchstabe.charAt(row) + "],Spalte[" + (col+1) +"] eine " + val + " zu setzten.\n");
		}
		
		return result;
	}

	private static Integer boxValue(Integer row, Integer col) {
		// erzeugt aus row und col einen box wert von 0 - 8
		Integer result = 0;
		result = (row / 3) * 3 + (col / 3);
		return result;
	}

	public void einfacheAusgabe() {
		boolean isPrinted = false;
		String trennZeile = "  -------------------------";
		System.out.println("    1 2 3   4 5 6   7 8 9");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (i % 3 == 0 && (!isPrinted)) {
					isPrinted = true;
					System.out.println(trennZeile);
				}
				if (j == 0)
					System.out.print(buchstabe.charAt(i) + " |");
				else if (j % 3 == 0)
					System.out.print(" |");
				System.out.print(" " + pa.feld[i][j].getValue());
			}
			System.out.print(" |");
			isPrinted = false;
			System.out.print(" row[" + i + "]: " + rowVal[i]);
			System.out.print("| col[" + i + "]: " + colVal[i]);
			System.out.print("| box[" + i + "]: " + boxVal[i]);
			System.out.println();
		}
		System.out.println(trennZeile + "\n");
	}
}
