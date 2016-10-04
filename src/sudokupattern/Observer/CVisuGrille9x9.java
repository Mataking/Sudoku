package sudokupattern.Observer;

import java.util.Observable;
import java.util.Observer;

public class CVisuGrille9x9 implements Observer{

	@Override
	public void update(Observable o, Object arg) {

		CGrille9x9 gr = (CGrille9x9)arg;
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

}
