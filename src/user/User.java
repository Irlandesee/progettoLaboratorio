package user;

import centri_vaccinali.operatore_sanitario.OperatoreSanitario;
//import cittadini.Cittadino;
public class User {

    /**
     * WARNING *
     * Usernames and passwords should always be handled hashed, never in plain Text!
     * WARNING *
     */
    private String user_name;
    private String user_password;
    private OperatoreSanitario opSanitario;

    public User(String user_name, String user_password){
        this.user_name = user_name;
        this.user_password = user_password;
    }

    public String getUser_Name(){
        return user_name;
    }

    public String getUser_password(){
        return user_password;
    }

    public boolean equals(Object obj){
        if(obj instanceof User)
            return this.user_name.equals(((User) obj).getUser_Name()) &&
                    this.user_password.equals(((User) obj).getUser_password());
        return false;
    }

    public String toString(){
        return "Hashed Username: " +this.user_name + "\nHashed user password: " +this.user_password;
    }

    private class NotAUserException extends Exception{

        public NotAUserException(){

        }

    }
}
