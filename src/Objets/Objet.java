package Objets;

/**
 * Created by lamg030499 on 2017-04-27.
 */
public class Objet {
    public String nom;
    public int valeur;


    public Objet(){
        nom = "Pièces d'or";
        valeur = 1;
    }
    public Objet(String nom, int valeur){
        this.nom = nom;
        this.valeur = valeur;
    }
    public Objet(int valeur){
        this.nom = "Pièces d'or";
        this.valeur = valeur;
    }
    public Objet(String nom){
        this.nom = nom;
        this.valeur = 1;
    }

    public String getNom(){
        return this.nom;
    }
    public int getValeur(){
        return this.valeur;
    }

    public String toString(){
        return (nom + ", valeur de " + valeur + " pièces.");
    }
}
