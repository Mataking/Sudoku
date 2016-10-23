package sudokupattern.Strategy.Factory;

import sudokupattern.Observer.CGrille9x9;
import sudokupattern.Strategy.Factory.Abstract.AbstractFileGrille;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Mata on 04/10/2016.
 */
public class FileGrille extends AbstractFileGrille {

    @Override
    public CGrille9x9 getFromFile(String name) {
        CGrille9x9 g = new CGrille9x9();

        ArrayList<String> liste = new ArrayList<String>();
        try{
            InputStream flux=new FileInputStream(name);

            InputStreamReader lecture=new InputStreamReader(flux);
            BufferedReader buff=new BufferedReader(lecture);
            String ligne;
        /* charge les donnees */
            while ((ligne=buff.readLine())!=null){
                liste.add(ligne);
            }
        /* ferme le fichier */
            buff.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }

    /* insere les donnees dans la grille */
        for (int i=0; i<liste.size(); i++)
        {
            String[] elems = (liste.get(i)).split(",");
            for (int c=0; c<elems.length; c++)
            {
                if (!elems[c].equals("0"))
                {
                    g.set(i+1, c+1, Integer.parseInt(elems[c]));
                }
            }
        }
        return g;
    }
}
