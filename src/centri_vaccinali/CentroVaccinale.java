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

    private qualificatoreIndirizzo quali;
    private tipologia tipo;


    public CentroVaccinale(){}

    public CentroVaccinale(String nomeCentroVaccinale, String nomeVia, String comune, String siglaProvincia, int cap,
                           int numeroCivico, String tipologia, String qualificatoreIndirizzo){
        this.nomeCentroVaccinale = nomeCentroVaccinale;
        this.nomeVia = nomeVia;
        this.comune = comune;
        this.siglaProvincia = siglaProvincia;
        this.cap = cap;
        this.numeroCivico = numeroCivico;
        this.setTipologia(tipologia);
        this.setQualificatore(qualificatoreIndirizzo);
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
                quali = qualificatoreIndirizzo.via;
                break;
            case "viale":
                quali = qualificatoreIndirizzo.viale;
                break;
            case "piazza":
                quali = qualificatoreIndirizzo.piazza;
                break;
        }
    }

    private void setTipologia(String t){
        switch(t){
            case "ospedale":
                tipo = tipologia.ospedale;
                break;
            case "hub":
                tipo = tipologia.hub;
                break;
            case "aziendale":
                tipo = tipologia.aziendale;
                break;
        }
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(this.getNomeCentroVaccinale());
        builder.append(" ");
        //tipologia
        if(this.tipo.equals(tipologia.hub))
            builder.append("hub");
        else if(this.tipo.equals(tipologia.ospedale))
            builder.append("ospedale");
        else
            builder.append("aziendale");
        builder.append(" ");
        //qualificatore indirizzo
        if(this.quali.equals(qualificatoreIndirizzo.via))
            builder.append("via");
        else if(this.quali.equals(qualificatoreIndirizzo.viale))
            builder.append("viale");
        else
            builder.append("piazza");
        builder.append(" ");
        builder.append(this.getNomeVia());
        builder.append(" ");
        builder.append(this.getNumeroCivico());
        builder.append(" ");
        builder.append(this.getComune());
        builder.append(" ");
        builder.append(this.getSiglaProvincia());
        builder.append(" ");
        builder.append(this.getCap());

        return builder.toString();
    }

}
