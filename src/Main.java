import gui.sanitari.RegistrazioneCentroVaccinaleWindow;
import gui.sanitari.SanitariMainWindow;
import org.json.*;
import loginhandler.LoginHandler;
import gui.MainWindow.MainWindow;

import java.io.*;
import java.util.LinkedList;
import java.util.Iterator;

public class Main {

    private final String error_pathname = "could not build path";
    private final String systemSeparator = File.separator;

    private String buildPath(){
        return "";
    }

    private void writeToFile(LinkedList<JSONObject> l, File f){
        try{
            BufferedWriter bW = new BufferedWriter(new FileWriter(f));
            Iterator<JSONObject> it = l.iterator();
            while(it.hasNext()){
                String s = it.next().toString();
                System.out.println(s);
                bW.append(s);
                bW.append("\n");
            }

            bW.close();
        }
        catch(IOException e){
            System.out.println("Error while opening: "+f.getAbsolutePath());
            e.printStackTrace();
        }
    }

    private LinkedList<JSONObject> readFromFile(File f){
        LinkedList<JSONObject> ris = new LinkedList<JSONObject>();
        try{
            BufferedReader bR = new BufferedReader(new FileReader(f));
            String line = "";
            while ((line = bR.readLine()) != null){
                JSONObject jObj = new JSONObject(line);
                ris.add(jObj);
            }
            bR.close();
        }catch(IOException e){
            System.out.println("Error while opening: " +f.getAbsolutePath());
            e.printStackTrace();
        }
        return ris;
    }

    public static void main(String[] args) throws Exception{
        System.out.println("Progetto Laboratorio");
        Main m = new Main();

        LoginHandler logHandler = new LoginHandler();

        /**
        String my_user_id = "mmlunardi";
        String my_user_pwd = "lnrmtm97";

        String hash_my_userID = logHandler.generateHash(my_user_id);
        String hash_my_userPWD = logHandler.generateHash(my_user_pwd);

        System.out.println("My hashed user id: " +hash_my_userID);
        System.out.println("My hashed user pwd: " +hash_my_userPWD);

         **/

        //LinkedList<JSONObject> users = new LinkedList<JSONObject>();

        //generating 1000 users
        /**
        for(int i = 0; i < 1000; i++){
            UserModel uM = UserModel.generateUser();
            JSONObject obj = uM.toJSON();
            users.add(obj);
        }

        logHandler.writeToFile(users);
        **/

        /**
        for(JSONObject obj : users){
            for(String key : obj.keySet()){
                System.out.println(key + " : "+ obj.get(key));
            }
            System.out.println("\n");
        }**/

        //testing gui
        //MainWindow mainWindow = new MainWindow();

        //new SanitariMainWindow();
        new RegistrazioneCentroVaccinaleWindow();

    }

}
