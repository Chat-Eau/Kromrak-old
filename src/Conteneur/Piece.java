package Conteneur;

/**
 * Created by lamg030499 on 2017-05-04.
 */
public class Piece {
    int valeur;

    public Piece(){
        valeur = 0;
    }
    public Piece(int valeur){
        this.valeur = valeur;
    }
    public void add(int i){valeur += i;}
    public int getValeur(){return valeur;}
    public String toString() {
        return valeur > 1 ? (valeur + " pièces d'or") : (valeur + " pièce d'or");
    }
}
