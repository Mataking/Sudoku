package sudokupattern.Fabrique;


import sudokupattern.Observer.CGrille9x9;

/**
 * Standardisation de la fabrique de grilles
 *
 */
public interface IAcquisitionGrille {

	public CGrille9x9 get();
}
