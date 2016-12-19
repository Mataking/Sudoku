package sudokupattern.Interface;

import sudokupattern.Observer.CGrille9x9;

/**
 * Created by Mata on 03/10/2016.
 */
public interface CSolveur9x9Impl {
    CGrille9x9 solve (CGrille9x9 grille);

    String gridToString(CGrille9x9 grid);
}
