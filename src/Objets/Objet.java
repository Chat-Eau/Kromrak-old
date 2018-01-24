package Objets;

public class Objet {
    public String nom;
    public int valeur;

    public Objet(String nom, int valeur){
        this.nom = nom;
        this.valeur = valeur;
    }

    public String getNom(){
        return this.nom;
    }
    public int getValeur(){
        return this.valeur;
    }
    public String toString(){
        return nom + ", valeur de " + valeur + " pièces.";
    }
}
