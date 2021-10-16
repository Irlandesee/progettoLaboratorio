package gui.LoginWindow;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.security.NoSuchAlgorithmException;

import loginhandler.LoginHandler;
import org.json.JSONObject;

public class LoginWindow extends JFrame{

    private Container cont;
    private GridBagLayout grdbagLayout;
    private GridBagConstraints grdConstraints;

    private JLabel lbl_userID;
    private JLabel lbl_userPWD;

    private JTextField txt_userID;
    private JTextField txt_userPWD;

    private JButton login;
    private JButton reset;

    private LoginHandler logHandler;

    public LoginWindow(String windowName){
        super(windowName);
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

        lbl_userID = new JLabel("USER ID: ");
        lbl_userPWD = new JLabel("USER PASSWORD: ");

        txt_userID = new JTextField(20);
        txt_userPWD = new JPasswordField(20);

        login = new JButton("ACCEDI");
        reset = new JButton("RESET");

        addComponent(lbl_userID, 0, 0, 1, 1);
        addComponent(lbl_userPWD, 1, 0, 1, 1);
        addComponent(txt_userID, 0, 1, 20, 1);
        addComponent(txt_userPWD, 1, 1, 20, 1);
        addComponent(reset,3, 0, 1, 1);
        addComponent(login, 3, 1,1, 1);

        ButtonHandler bHandler = new ButtonHandler();

        login.addActionListener(bHandler);
        reset.addActionListener(bHandler);

        //initializing login handler
        logHandler = new LoginHandler();

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

        private int columns_size = 20;
        private final String emptyString = "";
        private final String user_id = "user_id";
        private final String user_pwd = "user_pwd";
        private final String error_user_not_found = "user not found!";

        public void actionPerformed(ActionEvent e){
            if(e.getSource().equals(login)){
                String user_id_inserito = txt_userID.getText();
                String user_pwd_inserito = txt_userPWD.getText();
                if(!user_id_inserito.equals(emptyString) && !user_pwd_inserito.equals(emptyString)){
                    JSONObject tok = new JSONObject();
                    try{
                        tok = logHandler.buildToken(user_id_inserito, user_pwd_inserito); }
                    catch(NoSuchAlgorithmException exception){ exception.printStackTrace(); }
                    tok = logHandler.find(tok);
                    if(tok.get(user_id).equals(emptyString) && tok.get(user_pwd).equals(emptyString))
                        System.out.println(error_user_not_found);
                    else{ System.out.println(tok); }
                }
                resetFields();
            }
            else if(e.getSource().equals(reset)){
                resetFields();
            }
        }

        private void resetFields(){
            txt_userID.setText(emptyString);
            txt_userID.setColumns(columns_size);
            txt_userPWD.setText(emptyString);
            txt_userPWD.setColumns(columns_size);
        }

    }

}
