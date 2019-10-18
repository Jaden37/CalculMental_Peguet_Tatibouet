package bo;

import java.io.Serializable;

public class Question implements Serializable {

    private String libelle;
    private Double resultat;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Double getResultat() {
        return resultat;
    }

    public void setResultat(Double resultat) {
        this.resultat = resultat;
    }

    public Question() {
    }

    public Question(String libelle, Double resultat) {
        this.libelle = libelle;
        this.resultat = resultat;
    }
}
