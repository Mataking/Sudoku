package sudokupattern.Adapter;

import sudokupattern.Observer.CGrille9x9;

public interface IGrilleWriter {

	/**
	 * Standardisation de l'enregistrement
	 * @param grille
	 */
	public void save(CGrille9x9 grille);
	
}
