package sudokupattern.TP1.Decorateur;

import sudokupattern.TP1.Interface.Solveur;

/**
 * Created by Mata on 03/10/2016.
 */
public abstract class Decorateur implements Solveur{
    protected Solveur solveur9x9;

    public Decorateur (Solveur solveur9x9)
    {
        this.solveur9x9 = solveur9x9;
    }

}
