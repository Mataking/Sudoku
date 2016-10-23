package sudokupattern.Strategy.Factory;

import sudokupattern.Observer.CGrille9x9;
import sudokupattern.Strategy.Factory.Abstract.AbstractAutoGrille;

/**
 * Created by Mata on 04/10/2016.
 */
public class AutoGrille extends AbstractAutoGrille {
    /**
     * @param lvl
     *      lvl 1 = EASY
     *      lvl 2 = MEDIUM
     *      lvl 3 = HARD
     * @return
     */
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
