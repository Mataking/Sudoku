package sudokupattern.TP1;

import sudokupattern.Observer.CGrille9x9;
import sudokupattern.TP1.Interface.Solveur;

public class CSolveur9x9 implements Solveur {

	  public String chiffresPossibles(CGrille9x9 g, int l, int c) {
		
		/* au depart, tout est possible */
		boolean[] hyp = new boolean[9];
		for (int i=0; i<hyp.length; i++)
			hyp[i] = true;
		
		/* invalide les chiffres sur la ligne */
		for (int idxc=0; idxc<9; idxc++)
		{
			int nb = g.get(idxc+1, l); 
			if (nb != 0) {
				hyp[nb-1] = false;
			}
		}
		/* invalide les chiffre sur la colonne */
		for (int idxl=0; idxl<9; idxl++)
		{
			int nb = g.get(c, idxl+1); 
			if (nb != 0) {
				hyp[nb-1] = false;
			}
		}		
		/* invalide les chiffre dans le bloc */
    	int[] debc = {0, 0, 0, 3, 3, 3, 6, 6, 6}; // debut d'un bloc (colonne)
    	int[] debl = {0, 0, 0, 3, 3, 3, 6, 6, 6}; // debut d'un bloc (ligne)
    	int col = debc[c-1];  // 1er elem colonne du bloc
    	int lig = debl[l-1];  // 1er elem ligne du bloc
       	// recopie bloc dans une ligne pour simplifier
    	int elem[] = new int[9];
    	int rang = 0;
    	for (int idxc=col; idxc<col+3; idxc++) {
        	for (int idxl=lig; idxl<lig+3; idxl++) {    		
        		elem[rang++] = g.get(idxc+1, idxl+1);
        	}
    	}
    	// tous chiffres compris entre 0 et 9
    	for (int idx=0; idx<9; idx++) {
			if (elem[idx] != 0) {
				hyp[elem[idx]-1] = false;
			}
    	}

    	String chiffres = "";
    	for (int t=0; t<9; t++)
    	{
    		if (hyp[t]) 
    		{
    			chiffres = chiffres + (t+1);
    		}
    	} 	
		return chiffres;	
	}

	// remplissage automatique de la grille
	public CGrille9x9 solve (CGrille9x9 grille) {
		String[][] hyp = new String[9][9];

		boolean encore = true;
		boolean modifie = true;

		while (encore && modifie) {
			encore = false;
			modifie = false;
			/* liste toutes les possibilites de chiffres pour chaque case */
			for (int l = 0; l < 9; l++) {
				for (int c = 0; c < 9; c++) {
					if (grille.get(c + 1, l + 1) == 0) {
						hyp[l][c] = chiffresPossibles(grille, l + 1, c + 1);
					} else
						hyp[l][c] = "" + grille.get(c + 1, l + 1);
				}
			}
			/* reaffecte les elements unitaires */
			for (int l = 0; l < 9; l++) {
				for (int c = 0; c < 9; c++) {
					if (hyp[l][c].length() == 1) {
						grille.set(c + 1, l + 1, Integer.parseInt(hyp[l][c]));
						modifie = true;
					} else
						encore = true;
				}
			}
			/* ne boucle pas si pas de modif */
			if (!modifie) {
				System.out.println("Arret de resolution - Solveur a ameliorer");
				break;
			}
		}
		return grille;
	}
}

