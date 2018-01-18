package Effet;

/**
 * Created by Benjamin Laprise on 2018-01-17.
 */
public class Stat {
    private int valeur;
    private String nom;

    public Stat(String nom, int valeur ) {
        this.valeur = valeur;
        this.nom = nom;
    }

    public Stat(String nom) {
        this.valeur = 0;
        this.nom = nom;
    }

    public int getValeur() {
        return valeur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
}
