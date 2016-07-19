package sudoku;

import java.util.List;

public interface SudokuDAO {
	public boolean safe(Spielfeld game);

	public Spielfeld load(String gameName);

	public List<String> list();

	
	public boolean delete(String gameName);
}
 