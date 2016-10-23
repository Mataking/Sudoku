package sudokupattern.Strategy.Factory.Abstract;

import sudokupattern.Observer.CGrille9x9;

/**
 * Created by Mata on 04/10/2016.
 */
public abstract class AbstractFileGrille {
    public abstract CGrille9x9 getFromFile(String name);
}
