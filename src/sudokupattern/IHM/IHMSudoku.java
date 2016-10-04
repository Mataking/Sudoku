package sudokupattern.IHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
