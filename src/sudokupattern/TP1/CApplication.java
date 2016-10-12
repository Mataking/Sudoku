package sudokupattern.TP1;

import sudokupattern.Adapter.CGrilleXMLWriter;
import sudokupattern.IHM.IHMSudoku;
import sudokupattern.Iterator.Impl.ModeAcquisitionGrilleIteratorImpl;
import sudokupattern.Iterator.ModeAcquisitionGrilleContainer;
import sudokupattern.Observer.CGrille9x9;
import sudokupattern.Observer.CVisuGrille9x9;
import sudokupattern.Strategy.Factory.CAcquisitionGrille;
import sudokupattern.Strategy.Singleton.FactorySingleton;
import sudokupattern.TP1.Decorateur.DecoLog;
import sudokupattern.TP1.Interface.Solveur;


public class CApplication {

	// programme principal
	public static synchronized void main(String[] args) {

		ModeAcquisitionGrilleContainer modeAcquisitionGrilleContainer = new ModeAcquisitionGrilleContainer();

		IHMSudoku ihmSudoku = new IHMSudoku();


        FactorySingleton factorySingleton = FactorySingleton.getInstance();

		/**
		 * 	Afficher tous les mode possible pour générer une grille
		 * 	Voir le contenu dans
		 */
		System.out.println("Affichage des modes d'acquisition d'une grille : \n");
		for(ModeAcquisitionGrilleIteratorImpl iterContainerModeAcquisitionGrille = modeAcquisitionGrilleContainer.getModeAcquisitionGrilleIterator(); iterContainerModeAcquisitionGrille.hasNext();){
			String name = (String)iterContainerModeAcquisitionGrille.next();
			System.out.println("Name : " + name);
		}

		CGrille9x9 grille;

		// obtient une grille par strategy
		//CGrille9x9 grille = (new CAcquisitionGrille(new CFournisseur1())).get();

  /*      JFrame jFrame = new JFrame("IHMSudoku");
        jFrame.setContentPane(new IHMSudoku().getPrincipalPanel());
        jFrame.pack();
        jFrame.setVisible(true);*/

		switch (ihmSudoku.lectureConsole()){
			case "Fichier":
				grille = factorySingleton.getCAcquisitionGrille().getFileGrille().getFromFile("src//sudokupattern//grille.txt");
				break;
			case "Manuel":
				grille = factorySingleton.getCAcquisitionGrille().getManualGrille().getFromManuel();
				break;
			case "Image":
				grille = factorySingleton.getCAcquisitionGrille().getPictureGrille().getFromPicture();
				break;
            case "Automatique":
                grille = factorySingleton.getCAcquisitionGrille().getAutoGrille().getAutoGrille(2);
                break;
			default:
				grille = null;

				break;
		}

		if(grille != null){
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
		else
		{
			System.err.print("\nErreur lors de la selection.\nRetry le programme.\n");
		}
	}
}
