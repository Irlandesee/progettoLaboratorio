package centri_vaccinali.operatore_sanitario;

import java.time.LocalDate;

public class OperatoreSanitario{

    private String nome;
    private String cognome;
    private String codiceFiscale;
    private LocalDate dataNascita;

    public OperatoreSanitario(){}

    public OperatoreSanitario(String nome, String cognome, String codiceFiscale, LocalDate dataNascita){
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.dataNascita = dataNascita;
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

    public String getCodiceFiscale(){
        return this.codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale){
        this.codiceFiscale = codiceFiscale;
    }

    public LocalDate getDataNascita(){
        return this.dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita){
        this.dataNascita = dataNascita;
    }

    public String toString(){
        return "Nome: " + this.nome + "\nCognome: " + this.cognome + "\nCodice Fiscale: " + this.codiceFiscale
                +"\nData di Nascita: " +this.dataNascita.toString();
    }
}
