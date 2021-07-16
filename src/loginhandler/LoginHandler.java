package loginhandler;

import org.json.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.LinkedList;

public class LoginHandler {

    private final String userID = "user_id";
    private final String userPwd = "user_pwd";
    private final String pathname = "users/users.csv";

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

    public String generateHash(String s) throws NoSuchAlgorithmException{
        MessageDigest digest = MessageDigest.getInstance("SHA3-256");
        byte[] hashBytes = digest.digest(s.getBytes(StandardCharsets.UTF_8));
        String sha3hex = bytesToHex(hashBytes);
        return sha3hex;
    }

    public JSONObject buildToken(String user, String pwd) throws NoSuchAlgorithmException{
        JSONObject obj = new JSONObject();
        obj.put(userID, generateHash(user));
        obj.put(userPwd, generateHash(pwd));
        return obj;
    }

    public boolean compareTokens(JSONObject obj, JSONObject otherObj){
        //obj
        String objUserId = obj.get(userID).toString();
        String objUserPwd = obj.get(userPwd).toString();
        //other obj
        String otherUserId = otherObj.get(userID).toString();
        String otherUserPwd = otherObj.get(userPwd).toString();

        if(objUserId.equals(otherUserId) && objUserPwd.equals(otherUserPwd))
            return true;
        return false;
    }

    /**
     *
     * @param l
     */
    public void writeToFile(LinkedList<JSONObject> l){
        try{
            File f = new File(pathname);
            BufferedWriter bW = new BufferedWriter(new FileWriter(f));
            Iterator<JSONObject> it = l.iterator();
            while(it.hasNext()){

                JSONObject temp = it.next();
                String user_id = (String) temp.get(userID);
                String user_pwd = (String) temp.get(userPwd);
                //System.out.println("User_id: "+user_id +" user_pwd: "+user_pwd);
                try{
                    user_id = generateHash(user_id);
                    user_pwd = generateHash(user_pwd);
                    //System.out.println("Hashed User_id: "+user_id +"Hashed user_pwd: "+user_pwd);
                }
                catch(NoSuchAlgorithmException e){e.printStackTrace();}

                temp.put(userID, user_id);
                temp.put(userPwd, user_pwd);

                String s = temp.toString();
                //System.out.println(s);
                bW.append(s);
                bW.append("\n");
            }

            bW.close();
        }
        catch(IOException e){
            System.out.println("Error while opening: "+pathname);
            e.printStackTrace();
        }
    }

    /**
     *
     * @param obj
     */
    private void writeObj(JSONObject obj){

    }

    /**
     *
     * @return
     */
    public LinkedList<JSONObject> readFromFile(){
        LinkedList<JSONObject> ris = new LinkedList<JSONObject>();
        try{
            File f = new File(pathname);
            BufferedReader bR = new BufferedReader(new FileReader(f));
            String line = "";
            while ((line = bR.readLine()) != null){
                JSONObject jObj = new JSONObject(line);
                ris.add(jObj);
            }
            bR.close();
        }catch(IOException e){
            System.out.println("Error while opening: " +pathname);
            e.printStackTrace();
        }
        return ris;
    }

    /**
     *
     * @param obj
     * @return
     */
    public JSONObject find(JSONObject obj){
        LinkedList<JSONObject> l = readFromFile();

        String user_id = (String) obj.get(userID);
        String user_pwd = (String) obj.get(userPwd);

        System.out.println(user_id);
        System.out.println(user_pwd);

        for(JSONObject temp : l){

            String tempUser_id = temp.get(userID).toString();
            String tempUser_pwd = temp.get(userPwd).toString();

            if(tempUser_id.equals(user_id) && tempUser_pwd.equals(user_pwd)){
                System.out.println("********************+ Found User ********************");
                System.out.println("Nome:" +temp.get("nome"));
                System.out.println("Cognome: "+temp.get("cognome"));
                System.out.println("********************+ Found User ********************");
                //prova
                System.out.println(temp.toString());
                return temp;
            }
        }
        //user does not exists, return a json object which has user_id and user_pwd set as an empty
        //String
        JSONObject ris = new JSONObject();
        ris.put(userID, "");
        ris.put(userPwd, "");

        return ris;
    }

}
