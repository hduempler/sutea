package sudoku;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

class Sudoku {
	//@formatter:off
	public int[][] field = {
			{6,4,0,2,9,8,5,0,7},
			{0,5,2,1,0,6,9,8,4},
			{7,9,8,0,4,5,0,6,2},
			{9,0,3,6,1,4,8,7,0},
			{0,8,6,5,3,0,4,2,9},
			{5,7,4,0,8,2,6,0,3},
			{8,3,0,7,6,9,2,4,1},
			{4,1,9,8,0,3,7,5,6},
			{2,0,7,4,5,1,3,0,8}
	};
	//@formatter:on

	public int[] getSudokuRow(int row) {
		return field[row];
	}

	public int[] getSudokuCol(int col) {
		int[] result = new int[9];

		for (int i = 0; i < 9; i++) {
			result[i] = field[i][col];
		}

		return result;
	}

	public int[] getSudokuBox(int row, int col) {
		row = row / 3 * 3;
		col = col / 3 * 3;
		int[] result = new int[9];
		for (int i = 0; i < 3; i++) {
			System.arraycopy(field[row + i], col, result, i * 3, 3);
		}
		return result;
	}

	public Integer[] possibleValues(int row, int col) {
		List<Integer> list = new ArrayList<>();
		if (field[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (!ArrayUtils.contains(getSudokuRow(row), i)) {
					if (!ArrayUtils.contains(getSudokuCol(col), i)) {

						if (!ArrayUtils.contains(getSudokuBox(row, col), i)) {
							list.add(i);
						}
					}
				}

			}

		}
		return list.toArray(new Integer[0]);
	}
}

public class SudokuBitSetDemo {

	public static void print2DArray(int[][] array) {
		for (int[] a : array) {
			for (int i : a) {
				System.out.print("[" + (i == 0 ? " " : i) + "]");
			}
			System.out.println();
		}

	}

	public static void printArray(int[] array) {
		for (int i : array) {
			System.out.print("[" + (i == 0 ? " " : i) + "]");
		}
		System.out.println();

	}

	public static void printArray(Integer[] array) {
		for (int i : array) {
			System.out.print("[" + (i == 0 ? " " : i) + "]");
		}
		System.out.println();

	}

	public static void main(String[] args) {

		Sudoku sudoku = new Sudoku();

		print2DArray(sudoku.field);
		System.out.println();

		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				if (sudoku.field[r][c] == 0) {
					System.out.print("Zeile: " + r + " - Spalte: " + c + " - Mögliche Werte: ");
					printArray(sudoku.possibleValues(r, c));
				}

			}
		}

	}

}
