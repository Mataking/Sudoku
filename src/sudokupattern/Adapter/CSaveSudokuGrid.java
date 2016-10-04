package sudokupattern.Adapter;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class CSaveSudokuGrid {

	private int[][] grille;

	public CSaveSudokuGrid() {
		grille = new int[9][9];
	}

	// affecte les elements un a un pour enregistrement ulterieur
	public void def(int col, int lig, int val) {
		grille[col-1][lig-1] = val;
	}

	// enregistre dans le fichier mentionne (avec extension)
	public void save(String nomfichier) {

		BufferedWriter bufferedWriter = null;

		try {

			bufferedWriter = new BufferedWriter(new FileWriter(nomfichier));

			bufferedWriter.write("<grid width=\"9\" height=\"9\">\n");			
			bufferedWriter.write("   <lines>\n");
			for (int l=0; l<9; l++) {
				bufferedWriter.write("      <line index=\""+(l+1)+"\">\n");
					bufferedWriter.write("         <cols>\n");
					for (int c=0; c<9; c++) {
						bufferedWriter.write("            <column index=\""+(c+1)+"\">");
						bufferedWriter.write( String.valueOf(grille[c][l]) );
						bufferedWriter.write("</column>\n");
					}				
					bufferedWriter.write("         </cols>\n");
				bufferedWriter.write("      </line>\n");				
			}
			bufferedWriter.write("   </lines>\n");
			bufferedWriter.write("</grid>\n");

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			//Close the BufferedWriter
			try {
				if (bufferedWriter != null) {
					bufferedWriter.flush();
					bufferedWriter.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}	}
}
