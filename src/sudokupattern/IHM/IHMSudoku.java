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
