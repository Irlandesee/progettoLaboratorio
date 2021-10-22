package cittadini;

public class Cittadino {

    private String nome;
    private String cognome;
    private String codiceFiscale;

    public Cittadino(){}

    public Cittadino(String nome, String cognome, String codiceFiscale){
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCognome(){
        return this.cognome;
    }

    public void setCognome(String cognome){
        this.cognome = cognome;
    }

    public String getCodiceFiscale(){
        return this.codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale){
        this.codiceFiscale = codiceFiscale;
    }

    public boolean equals(Cittadino other){
        return this.getCodiceFiscale().equals(other.getCodiceFiscale());
    }

    public String toString(){
        return this.getCodiceFiscale();
    }

}
