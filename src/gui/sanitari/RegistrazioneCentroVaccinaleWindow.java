package gui.sanitari;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.MenuListener;
import java.awt.event.*;

public class RegistrazioneCentroVaccinaleWindow extends JFrame{

    private Container cont;
    private GridBagLayout grdbagLayout;
    private GridBagConstraints grdConstraints;

    private JButton btn_add;
    private JButton btn_reset;

    private JLabel lbl_nome_centro_vaccinale;
    private JLabel lbl_tipologia;
    private JLabel lbl_indirizzo_centro;

    private JTextField txt_nome_centro_vaccinale;
    private JTextField txt_tipologia;
    private JTextField txt_indirizzo;

    public RegistrazioneCentroVaccinaleWindow(){
        super("Registrazione centro vaccinale");
        createInterface();

        this.setSize(500, 400);
        this.setVisible(true);

    }

    private void createInterface(){
        cont = getContentPane();
        grdbagLayout = new GridBagLayout();
        cont.setLayout(grdbagLayout);

        grdConstraints = new GridBagConstraints();
        grdConstraints.fill = GridBagConstraints.BOTH;

        btn_add = new JButton("Aggiungi centro vaccinale");
        btn_reset = new JButton("Reset");


        lbl_nome_centro_vaccinale = new JLabel("Nome centro vaccinale");
        lbl_tipologia = new JLabel("tipologia");
        lbl_indirizzo_centro = new JLabel("indirizzo centro");

        txt_nome_centro_vaccinale = new JTextField(20);
        txt_tipologia = new JTextField(20);
        txt_indirizzo = new JTextField(20);

        addComponent(lbl_nome_centro_vaccinale, 0, 0, 1, 1);
        addComponent(lbl_tipologia, 1, 0, 1, 1);
        addComponent(lbl_indirizzo_centro, 2, 0, 1, 1);
        addComponent(txt_nome_centro_vaccinale, 0, 1, 20, 1);
        addComponent(txt_tipologia, 1, 1, 20, 1);
        addComponent(txt_indirizzo, 2, 1, 20, 1);
        addComponent(btn_add, 3, 0, 1, 1);
        addComponent(btn_reset, 3, 1, 1, 1);

        ButtonHandler bHandler = new ButtonHandler();
        btn_add.addActionListener(bHandler);
        btn_reset.addActionListener(bHandler);

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
            if(e.getSource().equals(btn_add)){
                System.out.println("add centro vaccinale");
            }
            else if(e.getSource().equals(btn_reset)){
                System.out.println("reset campi");
            }
        }

    }

    private class TextfieldHandler implements ActionListener{

        public void actionPerformed(ActionEvent e){

        }

    }

}
