package sudokupattern.TP1.Decorateur;

import sudokupattern.Observer.CGrille9x9;
import sudokupattern.TP1.Interface.CSolveur9x9Impl;

/**
 * Created by Mata on 03/10/2016.
 */
public class DecoLog extends Decorateur{

    public DecoLog(CSolveur9x9Impl solveurImpl9X9) {
        super(solveurImpl9X9);
    }

    @Override
    public String chiffresPossibles(CGrille9x9 g, int l, int c) {

        return solveurImpl9X9.chiffresPossibles(g, l, c);
    }

    @Override
    public CGrille9x9 solve(CGrille9x9 grille) {
        beginSolver();
        grille = solveurImpl9X9.solve(grille);

        endSolver();
        return grille;
    }

    private void beginSolver(){
        System.out.println("Début du solveur");
    }

    private void endSolver(){
        System.out.println("Fin du solveur");
    }
}
