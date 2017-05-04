package Objets;

import java.util.ArrayList;
import java.util.List;

import static Outils.Constantes.SEP;

/**
 * Created by lamg030499 on 2017-05-04.
 */
public class Conteneur {
    private List<Objet> objets = new ArrayList<>();
    private Piece pieces = new Piece(0);
    private String nom;

    public Conteneur(String nom){
        this.nom = nom;
    }

    public String getNom(){
        return this.nom;
    }

    public int size() { return objets.size();}
    public void add(Objet objet) { objets.add(objet);}
    public void add(int i) { this.pieces.valeur += i;}
    public void addAll(Conteneur cible) {
        cible.add(this.pieces.valeur);
        for (Objet objet: this.objets) {
            cible.add(objet);
        }
        this.objets.clear();
    }
    public Objet get(int i){
        return objets.get(i);
    }
    public Objet remove(int i){
        return objets.remove(i);
    }
    public int getPiece() { return pieces.valeur; }

    public String toString(){
        String string = this.pieces.toString() + SEP;
        for (int i = 0; i < objets.size(); i++){
            string += (i+1) + ". " + objets.get(i).toString();
            if (i < objets.size() -1){
                string += SEP;
            }
        }
        return string;
    }

}
