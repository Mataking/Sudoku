package sudokupattern.TP1.Decorateur;

import sudokupattern.TP1.Interface.CSolveur9x9Impl;

/**
 * Created by Mata on 03/10/2016.
 */
public abstract class Decorateur implements CSolveur9x9Impl {
    protected CSolveur9x9Impl solveurImpl9X9;

    public Decorateur (CSolveur9x9Impl solveurImpl9X9)
    {
        this.solveurImpl9X9 = solveurImpl9X9;
    }

}
