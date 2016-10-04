package sudokupattern.Strategy;

import sudokupattern.Observer.CGrille9x9;
import sudokupattern.Strategy.Impl.ManuelGrilleImpl;

/**
 * Created by Mata on 04/10/2016.
 */
public class ManuelGrille implements ManuelGrilleImpl {

    @Override
    public CGrille9x9 getFromManuel() {

        CGrille9x9 gr =  new CGrille9x9();

        gr.set(1, 1, 0);
        gr.set(2, 1, 0);
        gr.set(3, 1, 0);
        gr.set(4, 1, 0);
        gr.set(5, 1, 2);
        gr.set(6, 1, 0);
        gr.set(7, 1, 8);
        gr.set(8, 1, 0);
        gr.set(9, 1, 0);

        gr.set(1, 2, 9);
        gr.set(2, 2, 8);
        gr.set(3, 2, 0);
        gr.set(4, 2, 4);
        gr.set(5, 2, 6);
        gr.set(6, 2, 0);
        gr.set(7, 2, 0);
        gr.set(8, 2, 2);
        gr.set(9, 2, 3);

        gr.set(1, 3, 0);
        gr.set(2, 3, 2);
        gr.set(3, 3, 4);
        gr.set(4, 3, 0);
        gr.set(5, 3, 5);
        gr.set(6, 3, 0);
        gr.set(7, 3, 0);
        gr.set(8, 3, 1);
        gr.set(9, 3, 0);

        gr.set(1, 4, 0);
        gr.set(2, 4, 0);
        gr.set(3, 4, 0);
        gr.set(4, 4, 9);
        gr.set(5, 4, 0);
        gr.set(6, 4, 0);
        gr.set(7, 4, 0);
        gr.set(8, 4, 0);
        gr.set(9, 4, 8);

        gr.set(1, 5, 0);
        gr.set(2, 5, 7);
        gr.set(3, 5, 9);
        gr.set(4, 5, 0);
        gr.set(5, 5, 0);
        gr.set(6, 5, 8);
        gr.set(7, 5, 0);
        gr.set(8, 5, 0);
        gr.set(9, 5, 2);

        gr.set(1, 6, 8);
        gr.set(2, 6, 0);
        gr.set(3, 6, 3);
        gr.set(4, 6, 0);
        gr.set(5, 6, 1);
        gr.set(6, 6, 6);
        gr.set(7, 6, 7);
        gr.set(8, 6, 0);
        gr.set(9, 6, 9);

        gr.set(1, 7, 1);
        gr.set(2, 7, 3);
        gr.set(3, 7, 0);
        gr.set(4, 7, 7);
        gr.set(5, 7, 8);
        gr.set(6, 7, 4);
        gr.set(7, 7, 0);
        gr.set(8, 7, 0);
        gr.set(9, 7, 0);

        gr.set(1, 8, 0);
        gr.set(2, 8, 0);
        gr.set(3, 8, 0);
        gr.set(4, 8, 6);
        gr.set(5, 8, 0);
        gr.set(6, 8, 0);
        gr.set(7, 8, 3);
        gr.set(8, 8, 0);
        gr.set(9, 8, 0);

        gr.set(1, 9, 2);
        gr.set(2, 9, 0);
        gr.set(3, 9, 8);
        gr.set(4, 9, 0);
        gr.set(5, 9, 0);
        gr.set(6, 9, 0);
        gr.set(7, 9, 6);
        gr.set(8, 9, 7);
        gr.set(9, 9, 4);

        return gr;
    }
}
