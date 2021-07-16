package tok;

import org.json.JSONObject;

public class UserToken{

    private JSONObject token;
    private final String userID_String = "user_id";
    private final String userPassword_String = "user_password";


    public UserToken(String userName, String userPassword){
        buildUserToken(userName, userPassword);
    }

    private void buildUserToken(String userName, String userPassword){
        token = new JSONObject();
        token.put(userID_String, userName);
        token.put(userPassword_String, userPassword);
    }

    public JSONObject getToken(){
        return token;
    }

    public void setToken(JSONObject token){
        this.token = token;
    }

}
