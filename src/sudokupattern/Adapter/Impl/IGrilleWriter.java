package sudokupattern.Adapter.Impl;

import sudokupattern.Observer.CGrille9x9;

public interface IGrilleWriter {

	/**
	 * Standardisation de l'enregistrement
	 * @param grille
	 */
	void save(CGrille9x9 grille);
	
}
