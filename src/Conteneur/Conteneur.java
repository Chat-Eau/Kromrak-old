package Conteneur;

import Objets.Objet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Outils.Constantes.SEP;

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
    public void add(int i) { this.pieces.add(i);}
    public void addAll(Conteneur cible) {
        cible.add(this.pieces.getValeur());
        for (Objet objet: this.objets) {
            cible.add(objet);
        }
        this.objets.clear();
    }
    public void rndAdd(Conteneur source) {
        while (0 < source.size()) {
            if (new Random().nextInt(10) == 0) {
                this.add( source.get(0));
            }
            source.remove(0);
        }
    }

    public Objet get(int i){
        return objets.get(i);
    }
    public Objet remove(int i){
        return objets.remove(i);
    }
    public int getPiece() { return pieces.getValeur(); }

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
