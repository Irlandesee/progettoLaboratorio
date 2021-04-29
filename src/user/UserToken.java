package user;

import org.json.JSONObject;

public class UserToken extends User{

    private JSONObject userToken;

    public UserToken(String userName, String userPassword){
        super(userName, userPassword);
        buildUserToken();
    }

    private void buildUserToken(){
        final String userID_String = "user_id";
        final String userPassword_String = "user_password";

        userToken = new JSONObject();
        userToken.put(userID_String, super.getUser_Name());
        userToken.put(userPassword_String, super.getUser_password());

    }

    public JSONObject getUserToken(){
        return userToken;
    }

}
