package sudoku;

public class SudokuTeacherDemo {

	public static void main(String[] args) {
		//ein Puzzle holen (derzeit noch einfach ohne DAO)
		Spielfeld sf = new Spielfeld(1);
		for (int j = 1; j < 10; j++) {
			System.out.println(sf.rowVal[j]);
		}
		
	}

}
