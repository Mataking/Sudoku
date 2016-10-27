package sudokupattern.Decorateur;

import sudokupattern.Observer.CGrille9x9;
import sudokupattern.Interface.CSolveur9x9Impl;

/**
 * Created by Mata on 03/10/2016.
 */
public class DecoLog extends Decorateur{

    public DecoLog(CSolveur9x9Impl solveurImpl9X9) {
        super(solveurImpl9X9);
    }

    @Override
    public CGrille9x9 solve(CGrille9x9 grille) {
        beginSolver();
        grille = solveurImpl9X9.solve(grille);

        endSolver();
        return grille;
    }

    @Override
    public String gridToString(CGrille9x9 grid) {
        return null;
    }

    private void beginSolver(){
        System.out.println("Début du solveur");
    }

    private void endSolver(){
        System.out.println("Fin du solveur");
    }
}
