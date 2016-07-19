package sudoku;

public class SudokuTeacherDemo {

	public static int boxValue(int row, int col) {
		int result = (row / 3) * 3 + (col / 3);
		return result;
	}

	public static void main(String[] args) {
		MyBitSet[] bisRow = new MyBitSet[9];
		MyBitSet[] bisCol = new MyBitSet[9];
		MyBitSet[] bisBox = new MyBitSet[9];
		// ein Puzzle holen (derzeit noch einfach ohne DAO)
		PuzzleArray game = new PuzzleArray(1);

		for (int i = 0; i < 9; i++) {
			bisBox[i] = new MyBitSet(9);
			bisCol[i] = new MyBitSet(9);
			bisRow[i] = new MyBitSet(9);
		}

		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				bisRow[row].checkedSet(game.feld[row][col].getValue());
				bisCol[row].checkedSet(game.feld[col][row].getValue());
				bisBox[boxValue(row, col)].checkedSet(game.feld[row][col].getValue());
			}
		}
		for (int i = 0; i < 9; i++) {
			System.out.println("Die Box[" + i + "]: " + bisBox[i]);
			System.out.println("Die Reihe[" + i + "]: " + bisRow[i]);
			System.out.println("Die Spalte[" + i + "]: " + bisCol[i]);
		}
		PuzzleArray.einfacheAusgabe(game);

	}

}
