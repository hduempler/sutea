package sudoku;

public class SudokuEntry {

	private boolean fix = false;
	private Integer value = 0;

	public Integer getValue() {
		return value;
	}

	public boolean setValue(Integer value) {
		boolean result = false;
		if (!fix) {
			this.value = value;
			result = true;
		} 
		return result;
	}

}
