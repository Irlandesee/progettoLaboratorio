package loginhandler;

import org.json.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginHandler {

    private final String userID = "user_id";
    private final String userPwd = "user_pwd";

    public LoginHandler(){

    }

    private String bytesToHex(byte[] hash){
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    private String generateHash(String s) throws NoSuchAlgorithmException{
        MessageDigest digest = MessageDigest.getInstance("SHA3-256");
        byte[] hashBytes = digest.digest(s.getBytes(StandardCharsets.UTF_8));
        String sha3hex = bytesToHex(hashBytes);
        return sha3hex;
    }

    public JSONObject buildJsonToken(String user, String pwd) throws NoSuchAlgorithmException{

        JSONObject obj = new JSONObject();
        obj.put(userID, generateHash(user));
        obj.put(userPwd, generateHash(pwd));

        return obj;
    }

    public boolean compareTo(JSONObject obj, JSONObject otherObj){
        return obj.equals(otherObj);
    }


}
