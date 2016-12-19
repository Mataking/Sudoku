package sudokupattern.IHM;

import sudokupattern.CApplication;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;


/**
 * Created by Mata on 20/10/2016.
 */
public class IHM extends JFrame implements ItemListener, ActionListener {

        /**
         // A GARDER POUR L AFFICHAGE DU SUDOKU ET DU SOLVEUR

        private JTextField f[][]= new JTextField[9][9] ;
        private JPanel p[][]= new JPanel [3][3];

        public IHM(){
            super("Sudoku");

            for(int x=0; x<=8; x++){
                for(int y=0; y<=8; y++){
                    f[x][y]=new JTextField(1);
                }
            }

            for(int x=0; x<=2; x++){
                for(int y=0; y<=2; y++){
                    p[x][y]=new JPanel(new GridLayout(3,3));
                }
            }

            setLayout(new GridLayout(3,3,5,5));

            for(int u=0; u<=2; u++){
                for(int i=0; i<=2; i++){
                    for(int x=0; x<=2; x++ ){
                        for(int y=0; y<=2; y++){
                            p[u][i].add(f[y+u*3][x+i*3]);
                        }
                    }
                    add(p[u][i]);
                }
            }
        }
*/

         public IHM(){

             setTitle("Sudoku");

             initialisation();
             this.setVisible(true);
         }

        public void initialisation(){
            /** Creation de la fenetre de base **/
            // Reglage de la taille
            this.setSize(800, 700);
            // Positionnement au centre de l ecran
            this.setLocationRelativeTo(null);
            // Termine le processus si on clique sur la croix rouge
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // Titre de la fenetre
            this.setTitle("Solveur sudoku");
        }

        public void ajoutMethodAcquistion(){
            JPanel panel = new JPanel();
            Box bottom = Box.createVerticalBox();

            Border border = BorderFactory.createTitledBorder("Choix de l'acquisition");
            panel.setBorder(border);

            JLabel label = new JLabel("Ce programme permet de résoudre une grille du jeu de sudoku.");
            bottom.add(label);

            JLabel label1 = new JLabel("Veuillez choisir une méthode d'acquisition de grille :");
            bottom.add(label1);

            ButtonGroup group = new ButtonGroup();
            JRadioButton radio1 = new JRadioButton("A partir d'un fichier", true);
            radio1.setMnemonic(KeyEvent.VK_1);
            radio1.setActionCommand("1");

            JRadioButton radio2 = new JRadioButton("Manuellement");
            radio2.setMnemonic(KeyEvent.VK_2);
            radio2.setActionCommand("2");

            JRadioButton radio3 = new JRadioButton("A partir d'une image");
            radio3.setMnemonic(KeyEvent.VK_3);
            radio3.setActionCommand("3");

            JRadioButton radio4 = new JRadioButton("Automatiquement");
            radio4.setMnemonic(KeyEvent.VK_4);
            radio4.setActionCommand("4");

            group.add(radio1);
            group.add(radio2);
            group.add(radio3);
            group.add(radio4);

            radio1.addActionListener(this);
            radio2.addActionListener(this);
            radio3.addActionListener(this);
            radio4.addActionListener(this);

            radio1.addItemListener(this);
            radio2.addItemListener(this);
            radio3.addItemListener(this);
            radio4.addItemListener(this);

            bottom.add(radio1);
            bottom.add(radio2);
            bottom.add(radio3);
            bottom.add(radio4);


            panel.add(bottom);

            Container contentPane = this.getContentPane();
            contentPane.add(panel, BorderLayout.CENTER);
        }

    @Override
    public void itemStateChanged(ItemEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int method = Integer.parseInt(e.getActionCommand());
        CApplication.lecture(method);
        System.out.println("Clic sur le bouton : " +method);
        frameInit();
    }
}
