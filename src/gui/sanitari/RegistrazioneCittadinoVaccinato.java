package gui.sanitari;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import cittadini.Cittadino;
import centri_vaccinali.vaccinato.Vaccinato;
import java.util.Random;


public class RegistrazioneCittadinoVaccinato extends JFrame{

    private Container cont;
    private GridBagLayout grdbagLayout;
    private GridBagConstraints grdConstraints;

    /**
     * nome centro vaccinale
     * nome, cognome cittadino
     * codice fiscale
     * data somministrazione vaccino (gg/mm/aaaa)
     * vaccino somministrato (Pfizer, AstraZeneca, Moderna, J&J)
     * id univoco vaccinazione (id numerico su 16 bit)
     *
     * I dati di ogni cittadino vaccinato sono memorizzati
     * nel file dedicato denominato Vaccinati_nomeCentroVaccinale.dati(file .txt o .csv)
     */

    private JButton add_btn;
    private JButton rmv_btn;

    private JTextField nomeCentroVaccinale;
    private JTextField nomeCittadino;
    private JTextField cognomeCittadino;
    private JTextField codFiscale;

    private JLabel lbl_centroVaccinale;
    private JLabel lbl_nomeCittadino;
    private JLabel lbl_cognomeCittadino;
    private JLabel lbl_codFiscale;

    private JComboBox vaccino;

    private String[] vaccini = {"Pfizer", "Moderna", "AstraZeneca", "J&J"};

    public RegistrazioneCittadinoVaccinato(){
        super("Registrazione Cittadino Vaccinato");
        createInterface();
        this.setSize(600, 400);
        this.setVisible(true);
    }

    private void createInterface(){
        cont = getContentPane();

        grdbagLayout = new GridBagLayout();
        cont.setLayout(grdbagLayout);

        grdConstraints = new GridBagConstraints();
        grdConstraints.fill = GridBagConstraints.BOTH;

        lbl_centroVaccinale = new JLabel("Nome del centro vaccinale");
        lbl_nomeCittadino = new JLabel("Nome del cittadino");
        lbl_cognomeCittadino = new JLabel("Cognome del cittadino");
        lbl_codFiscale = new JLabel("Codice fiscale del cittadino");

        nomeCentroVaccinale = new JTextField(20);
        nomeCittadino = new JTextField(20);
        cognomeCittadino = new JTextField(20);
        codFiscale = new JTextField(20);

        vaccino = new JComboBox(vaccini);
        vaccino.setSelectedIndex(0);

        add_btn = new JButton("Registra vaccinato");
        rmv_btn = new JButton("Reset");

        ButtonHandler btnHandler = new ButtonHandler();
        TextfieldHandler txtHandler = new TextfieldHandler();

        addComponent(lbl_centroVaccinale, 0, 0 ,1, 1);
        addComponent(nomeCentroVaccinale, 0, 1, 20, 1);
        addComponent(lbl_nomeCittadino, 1, 0, 1, 1);
        addComponent(nomeCittadino, 1, 1, 20, 1);
        addComponent(lbl_cognomeCittadino, 2, 0,0, 1);
        addComponent(cognomeCittadino, 2, 1, 20, 1);
        addComponent(lbl_codFiscale, 3, 0, 1, 1);
        addComponent(codFiscale, 3, 1, 20, 1);
        addComponent(vaccino, 4, 0, 1,1);
        addComponent(add_btn, 4, 1,1, 1);
        addComponent(rmv_btn, 4, 2, 1, 1);

        add_btn.addActionListener(btnHandler);
        rmv_btn.addActionListener(btnHandler);

    }

    private void addComponent(Component c, int row, int column, int width, int height){
        grdConstraints.gridx = column;
        grdConstraints.gridy = row;
        grdConstraints.gridwidth = width;
        grdConstraints.gridheight = height;

        grdbagLayout.setConstraints(c, grdConstraints);
        cont.add(c);
    }

    private int generateUniqueId(){
        int uniqueId = 0;
        Random rand = new Random();

        return uniqueId;
    }

    private class ButtonHandler implements ActionListener{

        public void actionPerformed(ActionEvent e){
            if(e.getSource().equals(add_btn)){ //check dei campi -> invio dati
                System.out.println("add cittadino vaccinato");
                Cittadino citt = new Cittadino();
                Vaccinato v;
                String text = "";
                String centroVaccinale = "";
                String nomeCitt = "";
                String cognomeCitt = "";
                String codiceFisCitt = "";
                String vac = "";

                if(!((text = nomeCentroVaccinale.getText())).isBlank()){

                }
                if(!((text = nomeCittadino.getText())).isBlank()){
                    citt.setNome(text);
                }
                if(!((text = cognomeCittadino.getText())).isBlank()){
                    citt.setCognome(text);
                }
                if(!((text = codFiscale.getText())).isBlank()){
                    citt.setCodiceFiscale(text);
                }



            }
            else if(e.getSource().equals(rmv_btn)){

            }
        }

        private void resetComponent(Component c){
            JTextField txt = (JTextField) c;
            txt.setText("");
        }

    }

    private class TextfieldHandler implements ActionListener{

        public void actionPerformed(ActionEvent e){
            if(e.getSource().equals(nomeCentroVaccinale)){ //check che non ci siano numeri/caratteri speciali
                String txt = nomeCentroVaccinale.getText();
                if(checkForChars(txt)){
                    nomeCentroVaccinale.setText("");
                    JOptionPane.showMessageDialog(null, "Char warning", "Char Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
            else if(e.getSource().equals(nomeCittadino)){ //check che non ci siano numeri/caratteri speciali
                nomeCittadino.setText("");
                JOptionPane.showMessageDialog(null, "Char warning", "Char Warning", JOptionPane.WARNING_MESSAGE);
            }
            else if(e.getSource().equals(cognomeCittadino)){ //check che non ci siano numeri/caratteri speciali
                cognomeCittadino.setText("");
                JOptionPane.showMessageDialog(null, "Char warning", "Char Warning", JOptionPane.WARNING_MESSAGE);
            }
            else if(e.getSource().equals(codFiscale)){ //check che non ci siano caratteri speciali
                codFiscale.setText("");
                JOptionPane.showMessageDialog(null, "Char warning", "Char Warning", JOptionPane.WARNING_MESSAGE);
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

}
