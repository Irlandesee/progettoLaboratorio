package datamodel;

import java.util.Random;
import com.googlecode.jeneratedata.people.FemaleNameGenerator;
import com.googlecode.jeneratedata.people.MaleNameGenerator;
import com.googlecode.jeneratedata.people.LastNameGenerator;
import com.googlecode.jeneratedata.text.RandomStringGenerator;
import org.json.JSONObject;

public class UserModel {

    private String user_id;
    private String user_pwd;
    private String nome;
    private String cognome;
    private int eta;

    public UserModel(String user_id, String user_pwd, String nome,
        String cognome, int eta){
        this.user_id = user_id;
        this.user_pwd = user_pwd;
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public static UserModel generateUser(){
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        RandomStringGenerator randString = new RandomStringGenerator(20, alphabet);
        MaleNameGenerator maleGen = new MaleNameGenerator();
        FemaleNameGenerator femaleGen = new FemaleNameGenerator();
        LastNameGenerator cognomeGen = new LastNameGenerator();
        Random randInt = new Random();

        String user_id = randString.generate();
        String user_pwd = randString.generate();
        String nome = "";

        int maleOrFemale = randInt.nextInt(2);
        if(maleOrFemale == 0 )
            nome = maleGen.generate();
        else
            nome = femaleGen.generate();

        String cognome = cognomeGen.generate();

        int eta = randInt.nextInt(100);
        return new UserModel(user_id, user_pwd, nome, cognome, eta);
    }

    public JSONObject toJSON(){
        JSONObject obj = new JSONObject();
        obj.put("user_id", this.getUser_id());
        obj.put("user_pwd", this.getUser_pwd());
        obj.put("nome", this.getNome());
        obj.put("cognome", this.getCognome());
        obj.put("eta", this.getEta());

        return obj;
    }
}
