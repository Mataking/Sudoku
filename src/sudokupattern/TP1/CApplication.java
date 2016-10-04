package sudokupattern.TP1;


import sudokupattern.Adapter.CGrilleXMLWriter;
import sudokupattern.Observer.CGrille9x9;
import sudokupattern.Observer.CVisuGrille9x9;
import sudokupattern.Strategy.*;
import sudokupattern.TP1.Decorateur.DecoLog;
import sudokupattern.TP1.Interface.Solveur;

public class CApplication {

	public static final int FROM_FILE = 1;
	public static final int FROM_MANUEL = 2;
	public static final int FROM_PICTURE = 3;
    public static final int FROM_AUTO = 4;

	// programme principal
	public static void main(String[] args) {

		int method = 1;

		CGrille9x9 grille;

		// obtient une grille par strategy
		//CGrille9x9 grille = (new CAcquisitionGrille(new CFournisseur1())).get();

		switch (method){
			case FROM_FILE:
				grille = (new CAcquisitionGrille()).fileGrille.getFromFile("src//sudokupattern//grille.txt");
				break;
			case FROM_MANUEL:
				grille = (new CAcquisitionGrille()).manuelGrille.getFromManuel();
				break;
			case FROM_PICTURE:
				grille = (new CAcquisitionGrille()).pictureGrille.getFromPicture();
				break;
            case FROM_AUTO:
                grille = (new CAcquisitionGrille()).autoGrille.getAutoGrille(2);
                break;
			default:
				grille = null;

				break;
		}

		// obtient une grille par fabrique simple
		//CGrille9x9 grille2 = (new Fabrique.CAcquisitionGrille1()).get();
		
		// connecte l'observateur
		CVisuGrille9x9 visu = new CVisuGrille9x9();
		grille.addObserver(visu);

		// connecte décorateur
		// resoud
        Solveur decorateSolveur = (new DecoLog(new CSolveur9x9()));
        decorateSolveur.solve(grille);

		// enregistre dans xml
		CGrilleXMLWriter saver = new CGrilleXMLWriter("example.xml");
		saver.save(grille);
		 
	}

}
