package sudokupattern.IHM;

/**
 * Created by Mata on 23/10/2016.
 */

import sudokupattern.Observer.CGrille9x9;

import javax.swing.*;
import java.awt.*;
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

        //TESTS
        System.out.print("Le bon moment !");

        CGrille9x9 gr = (CGrille9x9)arg;
        afficherGrille(gr);

        System.out.println();
        for (int l=1; l<10; l++) {
            for (int c=1; c<10; c++) {
                System.out.print(gr.get(c, l) + " ");
                if (c<9 && c== 3 || c<9 && c== 6) System.out.print("| ");
            }
            if(l == 3 || l== 6){
                System.out.println("");
                System.out.println("------|-------|------");
            }
            else
                System.out.println("");
        }

    }


    //Fonction à modifier !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public void afficherGrille(CGrille9x9 grille){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Debut affichage grille");
        JTextField f[][]= new JTextField[9][9] ;
        JPanel p[][]= new JPanel [3][3];

        for(int x=0; x<=8; x++){
            for(int y=0; y<=8; y++){
                f[x][y]=new JTextField(grille.get(x+1,y+1));
            }
        }

        for(int x=0; x<=2; x++){
            for(int y=0; y<=2; y++){
                p[x][y]=new JPanel(new GridLayout(3,3));
            }
        }

        setLayout(new GridLayout(3,3,5,5));

        for(int u=0; u<=2; u++){
            for(int i=0; i<=2; i++){
               for(int x=0; x<=2; x++ ){
                   for(int y=0; y<=2; y++){
                        p[u][i].add(f[y+u*3][x+i*3]);
                    }
                }
                add(p[u][i]);
            }
        }


        System.out.println("Fin affichage grille");
    }

}
