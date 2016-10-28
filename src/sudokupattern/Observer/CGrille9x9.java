package sudokupattern.Observer;

/**
 * Created by Mata on 23/10/2016.
 */

import java.util.Observable;

/**
 * Modele
 */

public class CGrille9x9 extends Observable {
    private int[][] _data;

    // constructeur, allocation de la grille
    public CGrille9x9 () {
        _data = new int[9][9];
    }

    // setter : numeros de lignes et de colonnes commencent a 1
    public void set(int col, int lig, int val) {
        _data[col-1][lig-1] = val;
        setChanged();
        notifyObservers(this);
    }

    // getter : numeros de lignes et de colonnes commencent a 1
    public int get(int col, int lig) {
        return _data[col-1][lig-1];
    }
}