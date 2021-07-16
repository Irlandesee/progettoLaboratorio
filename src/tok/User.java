package tok;

import centri_vaccinali.operatore_sanitario.OperatoreSanitario;
import tok.UserException.NotAUser;
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
    private UserToken token;

    public User(){}

    public User(String user_name, String user_password){
        this.user_name = user_name;
        this.user_password = user_password;

        token = new UserToken(this.user_name, this.user_password);
    }

    public String getUser_name(){
        return user_name;
    }

    public String getUser_password(){
        return user_password;
    }

    public UserToken getUser_token(){
        return this.token;
    }

    public void setUser_token(UserToken token){
        this.token = token;
    }

    public boolean equals(Object obj){
        try{
            if(!(obj instanceof User))
                throw new NotAUser("Not a user!");
            return this.getUser_name().equals(((User) obj).getUser_name()) &&
                    this.getUser_password().equals(((User) obj).getUser_password());
        }catch(NotAUser e){
            return false;
        }
    }

    public String toString(){
        return "Hashed Username: " +this.user_name + "\nHashed user password: " +this.user_password;
    }

}
