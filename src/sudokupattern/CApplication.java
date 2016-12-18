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
	public static synchronized void main(String[] args) throws InterruptedException {

		ModeAcquisitionGrilleContainer modeAcquisitionGrilleContainer = new ModeAcquisitionGrilleContainer();

		CGrille9x9 cGrille9x9 = new CGrille9x9();

		CVisuGrille9x9 visu = new CVisuGrille9x9(cGrille9x9);


		//INITIALISATION DE L INTERFACE

		//Appel des methodes d'acquisition de l'ihm (A MODIFIER POUR AJOUTER GRACE A L ITERATOR)
		visu.ajoutMethodAcquistion();




		//Un debut de mvc qui se balade
		//Controleur controleur =  new Controleur(modele, vue);

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

			System.out.println("Analyse et chargement");

			Thread.sleep(2000);

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
			System.out.println("coucou");

			grille.addObserver(visu);

			visu.afficherGrille(grille);
			System.out.println("coucou");

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
