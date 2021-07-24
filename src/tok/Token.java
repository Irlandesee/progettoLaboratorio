package tok;

import org.json.JSONObject;

public class Token {

    private JSONObject tok;

    private final String id = "user_id";
    private final String pwd = "user_pwd";

    /**
     * Costruttore di comodo
     */
    public Token(){}

    public Token(String user_id, String user_pwd){
        if(!(user_id.equals("")) && !(user_pwd.equals("")))
            buildToken(user_id, user_pwd);

    }

    private void buildToken(String user_id, String user_pwd){
        tok.put(id, user_id);
        tok.put(pwd, user_pwd);
    }

    public JSONObject getToken(){
        return this.tok;
    }

    public void setToken(JSONObject tok){
        this.tok = tok;
    }

    public String toString(){
        return tok.toString();
    }

}
