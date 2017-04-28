package Objets;

/**
 * Created by lamg030499 on 2017-04-28.
 */
public class Consommable extends Objet {
    public Consommable(){
        super("Pomme", 3);
    }
    public Consommable(String nom, int valeur){
        super(nom, valeur);
    }
    public Consommable(int valeur){
        super("Pomme", valeur);
    }
    public Consommable(String nom){
        super(nom, 3);
    }

    public String getNom(){
        return this.nom;
    }
    public int getValeur(){
        return this.valeur;
    }
    public String toString(){
        return super.toString();
    }
}
