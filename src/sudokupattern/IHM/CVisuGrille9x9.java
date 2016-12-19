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


    public static final int GRID_SIZE = 9;    // Size of the board
    public static final int SUBGRID_SIZE = 3; // Size of the sub-grid
    // Name-constants for UI control (sizes, colors and fonts)
    public static final int CELL_SIZE = 60;   // Cell width/height in pixels
    public static final int CANVAS_WIDTH  = CELL_SIZE * GRID_SIZE;
    public static final int CANVAS_HEIGHT = CELL_SIZE * GRID_SIZE;
    // Board width/height in pixels

    public static final Color CLOSED_CELL_BGCOLOR = new Color(240, 240, 240); // RGB
    public static final Color CLOSED_CELL_TEXT = Color.BLACK;
    public static final Font FONT_NUMBERS = new Font("Monospaced", Font.BOLD, 20);


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

        initDisplayGrille(gr);

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

    public void initDisplayGrille(CGrille9x9 gr) {
        JTextField[][] tfCells = new JTextField[10][10];
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(9, 9));  // 9x9 GridLayout

        // Construct 9x9 JTextFields and add to the content-pane
        for (int l=1; l<10; l++) {
            for (int c=1; c<10; c++) {
                tfCells[c][l] = new JTextField(); // Allocate element of array
                cp.add(tfCells[c][l]);            // ContentPane adds JTextField

                tfCells[c][l].setText(gr.get(c, l) + " ");
                tfCells[c][l].setEditable(false);
                tfCells[c][l].setBackground(CLOSED_CELL_BGCOLOR);
                tfCells[c][l].setForeground(CLOSED_CELL_TEXT);

                // Beautify all the cells
                tfCells[c][l].setHorizontalAlignment(JTextField.CENTER);
                tfCells[c][l].setFont(FONT_NUMBERS);
            }
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Set the size of the content-pane and pack all the components
        //  under this container.
        cp.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        pack();

        setVisible(true);

        frameInit();
    }
}
