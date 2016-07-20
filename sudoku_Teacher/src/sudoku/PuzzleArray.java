package sudoku;

/*
 * aktuelle Baustelle 
 * Ich brauche eine Konstruktion in der mehrere Arrays mit Spielen hinterlegt werden können
 * Hier setzt hinterher auch die Persistierung an
 * 
 */

public class PuzzleArray {
	// eine 0 in myArray bedeutet das es im Sudoku für dieses Feld noch keinen
	// Wert gibt
	// alle anderen Werte entsprechen den üblichen Einträgen von 1 .. 9
	// (einschließlich)
	private static final String testGame[] = new String[4];
	private static final String REIHEN_TRENNER = ";";
	private static final String SPALTEN_TRENNER = ",";
	final SudokuEntry feld[][] = new SudokuEntry[9][9]; // hier solls rein

	public PuzzleArray(int index) {
		//	@formatter:off;
	testGame[0] =  "9,0,4,0,0,0,8,2,5;"	+"6,0,0,5,0,0,0,0,4;"	+"0,0,0,4,8,0,7,0,9;"
							+	"5,7,0,0,9,0,4,0,0;"	+"0,0,0,0,4,3,6,0,0;"	+"0,6,2,0,1,0,0,0,0;"
							+	"3,5,8,6,0,0,0,0,1;"	+"0,0,0,9,3,2,0,7,0;"	+"0,0,9,0,0,0,0,4,6;";

	testGame[1] =	"0,6,0,8,0,0,0,0,9;"+"0,0,0,9,0,6,0,7,1;"+"3,9,7,4,0,0,0,0,0;"
							+	"8,0,0,0,6,1,0,0,0;"+"5,0,0,0,8,4,9,3,0;"+"4,7,0,0,3,0,0,0,0;"
							+	"0,2,3,0,0,0,5,0,4;"+"0,4,0,1,0,0,6,0,0;"+"0,0,0,0,4,5,2,9,7;";

	testGame[2] = 	"7,0,0,6,0,0,1,0,0;"+"2,0,0,0,8,0,0,0,0;"+"0,0,0,0,0,0,0,3,0;"
							+  "0,5,3,0,0,0,0,4,0;"+"0,0,0,0,1,0,2,0,0;"+"0,0,0,0,0,0,0,0,0;"
							+  "0,6,0,3,0,5,0,0,0;"+"1,0,0,0,0,0,7,0,0;"+"0,0,0,4,0,0,0,0,0;";
	//System.out.println(testGame[0]);
	//	@formatter:on;
		/*
		 * kann ich den gewünschten Array erzeugen?
		 * als Ergebnis  setze ich feld[][] auf das entsprechende Soiel
		 */
		if (!(index >= 0 && index <= testGame.length)) {
			throw new RuntimeException("Für den Wert " + index
					+ " kann ich Dir kein Spiel liefern!\nErlaubte Werte Liegen von 0 bis " + (testGame.length - 1));
		}

		String reihen[];
		String spalten[];
		reihen = testGame[index].split(REIHEN_TRENNER);
		if (reihen.length != 9)
			throw new RuntimeException("Sudoku brauch 9 * 9 Felder! Falsche Werte gefunden!");
		for (int i = 0; i < reihen.length; i++) {
			spalten = reihen[i].split(SPALTEN_TRENNER);
			if (spalten.length != 9)
				throw new RuntimeException("Sudoku brauch 9 * 9 Felder! Falsche Werte gefunden!");
			for (int k = 0; k < spalten.length; k++) { // Teste die Werte in
														// Helper
				if (!(spalten[k].matches("[0-9]")))
					throw new RuntimeException("Ich habe ungültige Werte gefunden!");
				feld[i][k] = new SudokuEntry();
				feld[i][k].setFixValue(Integer.parseInt(spalten[k]));
			}
		}
	}
}
