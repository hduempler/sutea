package sudoku;

public class SudokuTeacherTextDemo {

	public static void main(String[] args) {
		// ein Puzzle holen (derzeit noch einfach ohne DAO)
		Spielfeld game = new Spielfeld(0);

//		game.setSudokuBitSets(bisRow, bisCol, bisBox, game);


		PuzzleArray.einfacheAusgabe(game.pa);
		// wie mache ich jetzt einen Zug?
		game.setEntry(1, 2, 1);
		game.showMyBitSet(); // kommt noch nichts an ??
		PuzzleArray.einfacheAusgabe(game.pa);

	}

}
