package sudoku;

import java.io.IOException;
import java.util.List;

public interface SudokuDAO {
	public boolean safe(Spielfeld game) throws IOException;

	public Spielfeld load(String gameName);

	public List<String> list();

	
	public boolean delete(String gameName);
}
