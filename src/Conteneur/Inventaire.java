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
    public void setCasque(Equipement casque) {
        Casque = casque;
    }
    public void setBottes(Equipement bottes) {
        Bottes = bottes;
    }
    public void setGants(Equipement gants) {
        Gants = gants;
    }
    public void setJambieres(Equipement jambieres) {
        Jambieres = jambieres;
    }
    public void setAnneau1(Equipement anneau1) {
        Anneau1 = anneau1;
    }
    public void setAnneau2(Equipement anneau2) {
        Anneau2 = anneau2;
    }
    public void setAmulette(Equipement amulette) {
        Amulette = amulette;
    }
    public void setAccessoire1(Equipement accessoire1) {
        this.accessoire1 = accessoire1;
    }
    public void setAccessoire2(Equipement accessoire2) {
        this.accessoire2 = accessoire2;
    }
    public void setAccessoire3(Equipement accessoire3) {
        this.accessoire3 = accessoire3;
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
    public Equipement getCasque() {
        return Casque;
    }
    public Equipement getBottes() {
        return Bottes;
    }
    public Equipement getGants() {
        return Gants;
    }
    public Equipement getJambieres() {
        return Jambieres;
    }
    public Equipement getAnneau1() {
        return Anneau1;
    }
    public Equipement getAnneau2() {
        return Anneau2;
    }
    public Equipement getAmulette() {
        return Amulette;
    }
    public Equipement getAccessoire1() {
        return accessoire1;
    }
    public Equipement getAccessoire2() {
        return accessoire2;
    }
    public Equipement getAccessoire3() {
        return accessoire3;
    }

    public String toString(){

        return "Arme : " + this.getArme1() + SEP +
                "Arme seconde main : " + this.getArme2() + SEP +
                "Plastron" + this.getPlastron() + SEP +
                super.toString();
    }
}
