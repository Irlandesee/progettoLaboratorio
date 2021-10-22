package centri_vaccinali.vaccinato;

import cittadini.Cittadino;

public class Vaccinato {

    private Cittadino citt;
    private String vaccino;

    public Vaccinato(){}

    public Vaccinato(Cittadino citt, String vaccino){
        this.citt = citt;
        this.vaccino = vaccino;
    }

    public Cittadino getCittadino(){
        return this.citt;
    }

    public void setCittadino(Cittadino citt){
        this.citt = citt;
    }

    public String getVaccino(){
        return this.vaccino;
    }

    public void setVaccino(String vaccino){
        this.vaccino = vaccino;
    }

    public String toString(){
        return this.getCittadino().toString() + " " + this.getVaccino();
    }

}
