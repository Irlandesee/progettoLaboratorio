package gui.sanitari;

import centri_vaccinali.CentroVaccinale;

import java.awt.*;
import javax.swing.*;
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
    private JLabel lbl_nome_via;
    private JLabel lbl_numero_civico;
    private JLabel lbl_comune;
    private JLabel lbl_sigla_provincia;
    private JLabel lbl_cap;

    private JTextField txt_nome_centro_vaccinale;
    private JTextField txt_nome_via;
    private JTextField txt_numero_civico; // only numbers!
    private JTextField txt_comune;
    private JTextField txt_sigla_provincia;
    private JTextField txt_cap; // only numbers!!

    private JComboBox combo_tipologia;
    private JComboBox combo_qualificatoriVia;
    private String[] tipiCentro = {"hub", "ospedale", "azienda"};
    private String[] qualificatoriVia = {"via", "viale", "piazza"};

    public RegistrazioneCentroVaccinaleWindow(){
        super("Registrazione centro vaccinale");
        createInterface();

        this.setSize(720, 400);
        this.setVisible(true);

    }

    private void createInterface(){
        cont = getContentPane();
        grdbagLayout = new GridBagLayout();
        cont.setLayout(grdbagLayout);

        grdConstraints = new GridBagConstraints();
        grdConstraints.fill = GridBagConstraints.BOTH;

        btn_add = new JButton("Aggiungi");
        btn_reset = new JButton("Reset");

        lbl_nome_centro_vaccinale = new JLabel("Nome centro vaccinale");
        lbl_tipologia = new JLabel("tipologia");
        lbl_indirizzo_centro = new JLabel("Via/Viale/Piazza");
        lbl_comune = new JLabel("Comune");
        lbl_nome_via = new JLabel("Nome via");
        lbl_numero_civico = new JLabel("Numero civico");
        lbl_sigla_provincia = new JLabel("Sigla provincia");
        lbl_cap = new JLabel("cap");

        txt_nome_centro_vaccinale = new JTextField(20);
        txt_nome_via = new JTextField(20);
        txt_numero_civico = new JTextField(5);
        txt_comune = new JTextField(20);
        txt_sigla_provincia = new JTextField();
        txt_cap = new JTextField();
        combo_tipologia = new JComboBox(tipiCentro);
        combo_qualificatoriVia = new JComboBox(qualificatoriVia);

        addComponent(lbl_nome_centro_vaccinale, 0, 0, 1, 1);
        addComponent(txt_nome_centro_vaccinale, 0, 1, 20, 1);
        addComponent(lbl_tipologia, 1, 0, 1, 1);
        addComponent(combo_tipologia,1, 1, 1, 1);
        addComponent(lbl_indirizzo_centro, 1, 2, 1, 1);
        addComponent(combo_qualificatoriVia, 1, 3, 1, 1);
        addComponent(lbl_nome_via, 2, 0, 1, 1);
        addComponent(txt_nome_via, 2, 1, 20, 1);
        addComponent(lbl_comune, 3, 0, 1,1);
        addComponent(txt_comune, 3, 1, 20, 1);
        addComponent(lbl_numero_civico, 4, 0, 1, 1);
        addComponent(txt_numero_civico,4, 1, 1, 1);
        addComponent(lbl_sigla_provincia, 4, 2, 1, 1);
        addComponent(txt_sigla_provincia, 4, 3, 1, 1);
        addComponent(lbl_cap, 5, 0, 1, 1);
        addComponent(txt_cap, 5, 1, 1, 1);
        addComponent(btn_add, 5, 2, 1, 1);
        addComponent(btn_reset, 5, 3, 1, 1);

        ButtonHandler bHandler = new ButtonHandler();
        btn_add.addActionListener(bHandler);
        btn_reset.addActionListener(bHandler);

        TextFieldHandler txtHandler = new TextFieldHandler();
        txt_cap.addActionListener(txtHandler);
        txt_numero_civico.addActionListener(txtHandler);
        txt_sigla_provincia.addActionListener(txtHandler);
        txt_comune.addActionListener(txtHandler);
        txt_nome_via.addActionListener(txtHandler);
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
                CentroVaccinale cv;
                String text = "";
                String tipologia = "";
                String nomeCentroVaccinale = "";
                String via = "";
                String nomeVia = "";
                String comune = "";
                String siglaProvincia = "";
                int numeroCivico = -1;
                int cap = -1;

                if(!((text = txt_nome_centro_vaccinale.getText()).isBlank()))
                    nomeCentroVaccinale = text;
                if(!((text = txt_nome_via.getText()).isBlank()))
                    nomeVia = text;
                if(!((text = txt_comune.getText()).isBlank()))
                    comune = text;
                if(!((text = txt_sigla_provincia.getText()).isBlank()))
                    siglaProvincia = text;
                if(!((text = txt_numero_civico.getText()).isBlank()))
                    numeroCivico = Integer.parseInt(text);
                if(!((text = txt_cap.getText()).isBlank()))
                    cap = Integer.parseInt(text);

                tipologia = combo_tipologia.getItemAt(combo_tipologia.getSelectedIndex()).toString();
                via = combo_qualificatoriVia.getItemAt(combo_qualificatoriVia.getSelectedIndex()).toString();

                cv = new CentroVaccinale(nomeCentroVaccinale, nomeVia, comune, siglaProvincia, cap, numeroCivico,
                tipologia, via);

                System.out.println("Centro vaccinale:\n"+cv);

            }
            else if(e.getSource().equals(btn_reset)){
                System.out.println("reset campi");
                resetTextFields();
            }
        }

        private void resetTextFields(){
            txt_nome_centro_vaccinale.setText("");
            txt_nome_via.setText("");
            txt_comune.setText("");
            txt_sigla_provincia.setText("");
            txt_numero_civico.setText("");
            txt_cap.setText("");
            combo_tipologia.setSelectedIndex(0);
            combo_qualificatoriVia.setSelectedIndex(0);
        }

    }

    private class TextFieldHandler implements ActionListener{

        public void actionPerformed(ActionEvent e){
            if(e.getSource().equals(txt_numero_civico)){
                String text = txt_numero_civico.getText();
                if(checkForChars(text)){//ci sono lettere
                    txt_numero_civico.setText("");
                    JOptionPane.showMessageDialog(null, "Char warning", "Char Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
            else if(e.getSource().equals(txt_cap)){
                String text = txt_cap.getText();
                if(checkForChars(text)){
                    txt_cap.setText("");
                    JOptionPane.showMessageDialog(null, "Char warning", "Char Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
            else if(e.getSource().equals(txt_comune)){
                String text = txt_comune.getText();
                if(checkForDigits(text)){//ci sono numeri
                    txt_comune.setText("");
                    JOptionPane.showMessageDialog(null, "Digits warning", "Digits Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
            else if(e.getSource().equals(txt_nome_via)){
                String text = txt_nome_via.getText();
                if(checkForDigits(text)){
                    txt_nome_via.setText("");
                    JOptionPane.showMessageDialog(null, "Digits warning", "Digits Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
            else if(e.getSource().equals(txt_sigla_provincia)){
                String text = txt_sigla_provincia.getText();
                if(checkForDigits(text)){
                    txt_sigla_provincia.setText("");
                    JOptionPane.showMessageDialog(null, "Digits warning", "Digits Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        /**
         * Metodo per controllare che non ci siano numeri
         * @param text
         * @return true se ce un numero nella stringa
         */
        private boolean checkForDigits(String text){
            for(int i = 0; i < text.length(); i++){
                if(Character.isDigit(text.charAt(i)))
                    return true;
            }
            return false;
        }

        /**
         * Metodo per controllare che non ci siano lettere
         * @param text
         * @return true se non ci sono lettere nella stringa
         */
        private boolean checkForChars(String text){
            for(int i = 0; i < text.length(); i++){
                if(!Character.isDigit(text.charAt(i)))
                    return true;
            }
            return false;
        }

    }

    /**
     * TO DO:
     * aggiungere check che ci siano tutti i parametri
     *
     */

}
