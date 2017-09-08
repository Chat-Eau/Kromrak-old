package Conteneur;

import Objets.Arme;
import Objets.Equipement;

import static Outils.Constantes.SEP;

public class Inventaire extends Conteneur{
    public Inventaire(String nom){
        super("Inventaire");
    }

    Arme arme1 = null;
    Arme arme2 = null;

    Equipement plastron = null;
    Equipement Casque = null;
    Equipement Bottes = null;
    Equipement Gants = null;
    Equipement Jambieres = null;

    Equipement Anneau1 = null;
    Equipement Anneau2 = null;
    Equipement Amulette = null;

    Equipement accessoire1 = null;
    Equipement accessoire2 = null;
    Equipement accessoire3 = null;

    public void setArme1(Arme armeIn) {
        if (true) { //TODO:Vérifier les conditions d'équipement
            if (false){ //TODO:Vérifier si l'arme équippée est à deux mains. Si vrai rentrer dans la boucle.
                this.add(arme2);
                this.arme2 = null;
            }
            if (this.arme1 != null) {
                this.add(this.arme1);
            }
            this.arme1 = armeIn;
        } else {
            System.out.println("Les conditions d'équipement ne sont pas respectées.");
        }
    }

    public void setArme2(Arme armeIn) {
        if (true) { //TODO:Vérifier les conditions d'équipement
            if (false){ //TODO:Vérifier si l'arme principale est à deux mains
                this.add(this.arme1);
                this.arme1 = null;
            } else if (this.arme2 != null) {
                this.add(this.arme2);
            }
            this.arme2 = armeIn;
        } else {
            System.out.println("Les conditions d'équipement ne sont pas respectées.");
        }
    }

    public void setPlastron(Equipement plastron) {
        if (true) { //TODO:Vérifier les conditions d'équipement
            if (this.plastron != null){
                this.add(this.plastron);
            }
            this.plastron = plastron;
        }
    }

    public Arme getArme1() {
        return arme1;
    }

    public Arme getArme2() {
        return arme2;
    }

    public Equipement getPlastron() {
        return plastron;
    }

    public String toString(){

        return "Arme : " + this.getArme1() + SEP +
                "Arme seconde main : " + this.getArme2() + SEP +
                "Plastron" + this.getPlastron() + SEP +
                super.toString();
    }
}
