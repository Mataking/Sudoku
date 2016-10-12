package sudokupattern.Strategy.Factory;

import sudokupattern.Observer.CGrille9x9;
import sudokupattern.Strategy.Factory.Impl.AutoGrilleImpl;

/**
 * Created by Mata on 04/10/2016.
 */
public class AutoGrille implements AutoGrilleImpl {
    /**
     * @param lvl
     *      lvl 1 = EASY
     *      lvl 2 = MEDIUM
     *      lvl 3 = HARD
     * @return
     */
    @Override
    public CGrille9x9 getAutoGrille(int lvl) {

        CGrille9x9 grille = new CGrille9x9();

        switch (lvl){
            case 1:
                break;

            case 2:
                break;

            case 3:
                break;

            default:
                return null;
        }
        return grille;
    }



}
