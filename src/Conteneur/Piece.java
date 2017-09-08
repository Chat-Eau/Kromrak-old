package Conteneur;

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
