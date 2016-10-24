package sudokupattern.IHM;

/**
 * Created by Mata on 23/10/2016.
 */

import sudokupattern.IHM.IHM;
import sudokupattern.Observer.CGrille9x9;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Vue
 */
public class CVisuGrille9x9 extends IHM implements Observer {

    CGrille9x9 cGrille9x9;

    public CVisuGrille9x9(CGrille9x9 cGrille9x9){
        this.cGrille9x9 = cGrille9x9;

        cGrille9x9.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

        CGrille9x9 gr = (CGrille9x9)arg;
        System.out.println();
        for (int l=1; l<10; l++) {
            for (int c=1; c<10; c++) {
                System.out.print(gr.get(c, l) + " ");
                if (c<9 && c== 3 || c<9 && c== 6) System.out.print("| ");
            }
            if(l == 3 || l== 6){
                System.out.println("");
                JLabel la = new JLabel();
                System.out.println("------|-------|------");
            }
            else
                System.out.println("");
        }

    }

}
