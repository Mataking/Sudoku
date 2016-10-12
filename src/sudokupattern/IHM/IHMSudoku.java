package sudokupattern.IHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.sun.glass.ui.Cursor.setVisible;

/**
 * Created by Mata on 04/10/2016.
 */
public class IHMSudoku {

    public String lectureConsole() {
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


    private JPanel principalPanel;
    private JButton button1;

    public JPanel getPrincipalPanel() {
        return principalPanel;
    }

    public IHMSudoku(){
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(null,"hello");
            }
        });
    }
}
