package Objets;

/**
 * Created by lamg030499 on 2017-04-28.
 */
public class Tresor extends Objet {

    //TODO:GLM: Le trésor est litérallement juste un objet. Est-ce que les trésors (Or, pierres précieuses, etc...)
    //TODO:GLM: Devraient être simplement des objets?
    public Tresor(){
        nom = "Pièces d'or";
        valeur = 1;
    }
    public Tresor(String nom, int valeur){
        this.nom = nom;
        this.valeur = valeur;
    }
    public Tresor(int valeur){
        this.nom = valeur > 1 ? "Pièces d'or" : "Pièce d'or";
        this.valeur = valeur;
    }
    public Tresor(String nom){
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
