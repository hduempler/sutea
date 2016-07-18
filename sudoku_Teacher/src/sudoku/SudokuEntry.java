package sudoku;

public class SudokuEntry {

	private boolean fix = false;
	private Integer value = 0;

	public Integer getValue() {
		return value;
	}

	public boolean setValue(Integer value) {
		// prüft auf veränderlichen Eintag
		boolean result = false;
		if (!fix) {
			this.value = value;
			result = true;
		}
		return result;
	}

	public void setFixValue(Integer value) {
		// Methode zum setzen der unveränderlichen Einträge
		assert (this.fix == false) : "Ich sollte nichts setzen was schon gesetzt ist!" ;
		this.fix = true;
		this.value = value;
	}
}
