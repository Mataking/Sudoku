package sudokupattern;

import sudokupattern.Adapter.CGrilleXMLWriter;
import sudokupattern.Iterator.Impl.ModeAcquisitionGrilleIteratorImpl;
import sudokupattern.Iterator.ModeAcquisitionGrilleContainer;
import sudokupattern.Observer.CGrille9x9;
import sudokupattern.IHM.CVisuGrille9x9;
import sudokupattern.Strategy.Singleton.FactorySingleton;
import sudokupattern.Decorateur.DecoLog;
import sudokupattern.Interface.CSolveur9x9Impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CApplication {

	// programme principal
	public static synchronized void main(String[] args) {

		ModeAcquisitionGrilleContainer modeAcquisitionGrilleContainer = new ModeAcquisitionGrilleContainer();

		CGrille9x9 cGrille9x9 = new CGrille9x9();

		CVisuGrille9x9 visu = new CVisuGrille9x9(cGrille9x9);


		//Controleur controleur =  new Controleur(modele, vue);

		visu.pack();
		visu.setVisible(true);


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

		switch (lectureConsole()){
			case "Fichier":
				grille = factorySingleton.getCAcquisitionGrille().getFileGrille().getFromFile("src//sudokupattern//grille.txt");
				break;
			case "Manuel":
				grille = factorySingleton.getCAcquisitionGrille().getManualGrille().getFromManuel();
				break;
			case "Image":
				grille = factorySingleton.getCAcquisitionGrille().getPictureGrille().getFromPicture("");
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
			//CVisuGrille9x9 visu = new CVisuGrille9x9();
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

    public static String lectureConsole() {
        BufferedReader br = null;
        String input = null;

        try {

            br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("-----------\n");

            System.out.print("Enter your type mode manually : ");
            input = br.readLine();

            if ("q".equals(input)) {
                System.exit(0);
            }

            System.out.println("-----------\n");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return input;
    }
}
