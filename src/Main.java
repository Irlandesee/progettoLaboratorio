import org.json.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

    private static String bytesToHex(byte[] hash) {
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

    public static String generateHash(String s) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA3-256");
        byte[] hashBytes = digest.digest(s.getBytes(StandardCharsets.UTF_8));
        String sha3hex = bytesToHex(hashBytes);
        return sha3hex;
    }

    private static JSONObject buildJsonToken(String user, String password) throws NoSuchAlgorithmException{
        String userID = "userID";
        String userPassword = "userPassword";

        JSONObject obj = new JSONObject();
        obj.append(userID, generateHash(user));
        obj.append(userPassword, generateHash(password));

        return obj;
    }

    public static void main(String[] args) throws Exception{
        System.out.println("Progetto Laboratorio");

        String user = "MattiaLunardi";
        String password = "bastardGoat";

        JSONObject obj = buildJsonToken(user, password);

        System.out.println(obj.toString());
        System.out.println(obj.get("userID").toString());
        System.out.println(obj.get("userPassword").toString());

    }

}
