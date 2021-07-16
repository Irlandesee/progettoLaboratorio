package gui.MainWindow;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.MenuListener;
import java.awt.event.*;
import gui.LoginWindow.LoginSanitari.LoginWindowSezioneSanitari;

public class MainWindow extends JFrame{

    private Container cont;
    private GridBagLayout grdbagLayout;
    private GridBagConstraints grdConstraints;

    private JButton btn_sanitari;
    private JButton btn_cittadini;
    private JButton btn_nuovoUtente;

    public MainWindow(){
        super("Progetto Laboratorio");
        createInterface();

        this.setSize(400, 400);
        this.setVisible(true);
    }

    private void createInterface(){
        cont = getContentPane();
        grdbagLayout = new GridBagLayout();
        cont.setLayout(grdbagLayout);

        //instantiang constraints
        grdConstraints = new GridBagConstraints();
        grdConstraints.fill = GridBagConstraints.BOTH;

        btn_sanitari = new JButton("Accesso Sezione Operatori Sanitari");
        btn_cittadini = new JButton("Accesso Sezione cittadini");
        btn_nuovoUtente = new JButton("Registrazione nuovo utente");

        addComponent(btn_sanitari, 0, 0, 1, 1);
        addComponent(btn_cittadini, 1, 0, 1, 1);
        addComponent(btn_nuovoUtente, 2, 0, 1, 1);

        ButtonHandler bHandler = new ButtonHandler();
        btn_sanitari.addActionListener(bHandler);
        btn_cittadini.addActionListener(bHandler);
        btn_nuovoUtente.addActionListener(bHandler);

    }

    private void addComponent(Component c, int row, int column, int width, int height){
        grdConstraints.gridx = column;
        grdConstraints.gridy = row;
        grdConstraints.gridwidth = width;
        grdConstraints.gridheight = height;

        grdbagLayout.setConstraints(c, grdConstraints);
        cont.add(c);
    }

    private class ButtonHandler implements ActionListener{

        public void actionPerformed(ActionEvent e){
            if(e.getSource().equals(btn_sanitari)){
                System.out.println("Sanitari");
                new LoginWindowSezioneSanitari();
            }
            else if(e.getSource().equals(btn_cittadini)){
                System.out.println("Cittadini");

            }
            else if(e.getSource().equals(btn_nuovoUtente)){
                System.out.println("Nuovo utente");
            }
        }

    }

}
