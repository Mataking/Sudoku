package sudokupattern.Adapter;

import sudokupattern.Adapter.Impl.IGrilleWriter;
import sudokupattern.Observer.CGrille9x9;

public class CGrilleXMLWriter implements IGrilleWriter {

	private CSaveSudokuGrid _saver;
	private String _nom;
	
	public CGrilleXMLWriter(String n) {
		_nom = n;
	}

	@Override
	public void save(CGrille9x9 grille) {

		_saver = new CSaveSudokuGrid();
		for (int c=1; c<10; c++)
			for (int l=1; l<10; l++)
				_saver.def(c, l, grille.get(c, l));
		_saver.save(new String(_nom));
	}
	
	
}
