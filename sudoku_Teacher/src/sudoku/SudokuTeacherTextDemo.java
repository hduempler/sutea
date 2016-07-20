package sudoku;

public class SudokuTeacherTextDemo {

	public static void main(String[] args) {
		// ein Puzzle holen (derzeit noch einfach ohne DAO)
		Spielfeld game = new Spielfeld(0);

		// game.setSudokuBitSets(bisRow, bisCol, bisBox, game);

		game.einfacheAusgabe();
		// wie mache ich jetzt einen Zug?
		game.setEntry(1, 2, 1, true);
		// was gibt es wenn der Zug auf einem gesetzten Feld einen anderen Value schriebt
		game.setEntry(1, 2, 6, true);
		// jetzt setzte ich auf ein geschütztes Feld
		game.setEntry(0, 0, 6, true); // wie erwartet wird das geblockt

	}

}
