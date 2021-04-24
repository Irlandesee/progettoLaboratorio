package centri_vaccinali;

import java.util.Arrays;

public class CentroVaccinale {

    private String nomeCentroVaccinale;

    private enum tipologia{
        ospedale,
        aziendale,
        hub
    };

    private enum qualificatoreIndirizzo {
        via,
        viale,
        piazza
    }

    private String nomeVia;
    private String comune;
    private String siglaProvincia;
    private int cap;
    private int numeroCivico;

    public CentroVaccinale(){}

    public CentroVaccinale(String nomeCentroVaccinale, String nomeVia, String comune, String siglaProvincia, int cap,
                           int numeroCivico, String tipologia, String qualificatoreIndirizzo){
        this.nomeCentroVaccinale = nomeCentroVaccinale;
        this.nomeVia = nomeVia;
        this.comune = comune;
        this.siglaProvincia = siglaProvincia;
        this.cap = cap;
        this.numeroCivico = numeroCivico;

    }

    public String getNomeCentroVaccinale() {
        return nomeCentroVaccinale;
    }

    public void setNomeCentroVaccinale(String nomeCentroVaccinale) {
        this.nomeCentroVaccinale = nomeCentroVaccinale;
    }

    public String getNomeVia() {
        return nomeVia;
    }

    public void setNomeVia(String nomeVia) {
        this.nomeVia = nomeVia;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public String getSiglaProvincia() {
        return siglaProvincia;
    }

    public void setSiglaProvincia(String siglaProvincia) {
        this.siglaProvincia = siglaProvincia;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public int getNumeroCivico() {
        return numeroCivico;
    }

    public void setNumeroCivico(int numeroCivico) {
        this.numeroCivico = numeroCivico;
    }

    private void setQualificatore(String qualificatore){
        switch(qualificatore){
            case "via":
                qualificatoreIndirizzo q = qualificatoreIndirizzo.via;
                break;
            case "viale":
                qualificatoreIndirizzo qI = qualificatoreIndirizzo.viale;
                break;
            case "piazza":
                qualificatoreIndirizzo tmp = qualificatoreIndirizzo.piazza;
                break;
        }
    }

    private void setTipologia(String t){
        switch(t){
            case "ospedale":
                tipologia tip = tipologia.ospedale;
                break;
            case "hub":
                tipologia tmp = tipologia.hub;
                break;
            case "aziendale":
                tipologia temp = tipologia.aziendale;
        }
    }

    public String toString(){
        return "Nome Centro vaccinale: " +"\nTipologia: " + Arrays.toString(tipologia.values()) + "\nIndirizzo"
                + Arrays.toString(qualificatoreIndirizzo.values()) + this.nomeVia + this.numeroCivico +
                "\nComune:"+ this.comune +"\nProvincia: " + this.siglaProvincia + "\nCap:" +this.cap;
    }

}
