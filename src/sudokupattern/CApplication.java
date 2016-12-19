package sudokupattern;

import sudokupattern.Adapter.CGrilleXMLWriter;
import sudokupattern.IHM.IHM;
import sudokupattern.Iterator.Impl.ModeAcquisitionGrilleIteratorImpl;
import sudokupattern.Iterator.ModeAcquisitionGrilleContainer;
import sudokupattern.Observer.CGrille9x9;
import sudokupattern.IHM.CVisuGrille9x9;
import sudokupattern.Strategy.Singleton.FactorySingleton;
import sudokupattern.Decorateur.DecoLog;
import sudokupattern.Interface.CSolveur9x9Impl;

public class CApplication {

	public static int choixAcquisitionGrille = 0;

	// programme principal
	public static synchronized void main(String[] args) {

		ModeAcquisitionGrilleContainer modeAcquisitionGrilleContainer = new ModeAcquisitionGrilleContainer();

		CGrille9x9 cGrille9x9 = new CGrille9x9();

		CVisuGrille9x9 visu = new CVisuGrille9x9(cGrille9x9);

		//INITIALISATION DE L INTERFACE

		visu.ajoutMethodAcquistion();

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

		CGrille9x9 grille = null;


		
		while(choixAcquisitionGrille == 0){

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			switch (choixAcquisitionGrille){
				case 1:
					grille = factorySingleton.getCAcquisitionGrille().getFileGrille().getFromFile("src//sudokupattern//grille.txt");
					break;
				case 2:
					grille = factorySingleton.getCAcquisitionGrille().getManualGrille().getFromManuel();
					break;
				case 3:
					grille = factorySingleton.getCAcquisitionGrille().getPictureGrille().getFromPicture();
					break;
				case 4:
					grille = factorySingleton.getCAcquisitionGrille().getAutoGrille().getAutoGrille(2);
					break;
				default:
					choixAcquisitionGrille = 0;
					grille = null;
	
					break;
			}
		}

		if(grille != null){
			grille.addObserver(visu);

			// connecte décorateur
			// resoud
			CSolveur9x9Impl decorateSolveurImpl = (new DecoLog(new CSolveur9x9()));
			decorateSolveurImpl.solve(grille);

			// enregistre dans xml
			CGrilleXMLWriter saver = new CGrilleXMLWriter("example.xml");
			saver.save(grille);
		}
		else
		{
			System.err.print("\nErreur lors de la selection.\nRetry le programme.\n");
		}
	}

	public static void lecture(int choix) {
		choixAcquisitionGrille = choix;
	}
}
