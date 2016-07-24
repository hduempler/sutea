package sudoku;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;


public class SudokuDAOImpl implements SudokuDAO {
	
	public static void main(String[] args) {
	}

	@Override
	public boolean safe(Spielfeld game) throws FileNotFoundException, IOException  {
		String path = "resources/savedGames.ser";
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
			Spielfeld ser = game;
			oos.writeObject(ser);
		}
		return false;
	}

	@Override
	public Spielfeld load(String gameName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String gameName) {
		// TODO Auto-generated method stub
		return false;
	}
}
