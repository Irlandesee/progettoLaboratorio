package gui.sanitari;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SanitariMainWindow extends JFrame{

    private Container cont;
    private GridBagLayout grdbagLayout;
    private GridBagConstraints grdConstraints;

    private JButton btn_reg_cittadino;
    private JButton btn_reg_centro;

    public SanitariMainWindow(){
        super("Sanitari Main Window");

        createInterface();

        this.setSize(400, 400);
        this.setVisible(true);
    }

    private void createInterface(){
        cont = getContentPane();
        grdbagLayout = new GridBagLayout();
        cont.setLayout(grdbagLayout);

        grdConstraints = new GridBagConstraints();
        grdConstraints.fill = GridBagConstraints.BOTH;

        btn_reg_centro = new JButton("Registra centro Vaccinale");
        btn_reg_cittadino = new JButton("Registra cittadino vaccinato");

        addComponent(btn_reg_centro, 0, 0, 1, 1);
        addComponent(btn_reg_cittadino, 1, 0, 1, 1);

        ButtonHandler bHandler = new ButtonHandler();
        btn_reg_centro.addActionListener(bHandler);
        btn_reg_cittadino.addActionListener(bHandler);

    }

    private void addComponent(Component c, int row, int column, int width, int height){
        grdConstraints.gridx = column;
        grdConstraints.gridy = row;
        grdConstraints.gridwidth = width;
        grdConstraints.gridheight = height;

        grdbagLayout.setConstraints(c, grdConstraints);
        cont.add(c);
    }

    private class ButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent e){
            if(e.getSource().equals(btn_reg_centro)){
                System.out.println("Registrazione centro vaccinale");
                //new RegistrazioneCentroVaccinaleWindow();
            }
            else if(e.getSource().equals(btn_reg_cittadino)){
                System.out.println("Registrazione cittadino vaccinato");
                //new RegistrazioneCittadinoVaccinatoWindow();
            }
        }
    }

}
