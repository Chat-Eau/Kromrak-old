package Conteneur;

import Objets.Arme;
import Objets.Equipement;
import Objets.Objet;

import java.util.ArrayList;
import java.util.List;

import static Outils.Constantes.SEP;

public class Inventaire extends Conteneur{
    public Inventaire(String nom){
        super("Inventaire");
    }

    Arme arme1 = null;
    Arme arme2 = null;

    //0:Chest, 1:Head, 2:Feet, 3:Hands, 4:Legs, 5:Finger1,
    //6:Finger2, 7:Neck, 8:Accessory1, 9:Accessory2, 10:Accessory3
    private List<Equipement> equipements = new ArrayList<>();


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

    public void equip(Equipement equipment) {
        if (true) {
            //TODO:Vérifier les conditions d'équipement
            return;
        }
        for (Equipement slot:equipements) {
            if (slot.getType() == equipment.getType()){
                unequip(equipment);
                break;
            }
        }
        equipements.add(equipment);
    }

    public Equipement getEquipment(String type) {
        for (Equipement equipement:equipements) {
            if (equipement.getType() == type){
                return equipement;
            }
        }
        return null;
    }

    public void unequip(Equipement equipement){
        equipements.remove(equipement);
    }

    public Arme getArme1() {
        return arme1;
    }
    public Arme getArme2() {
        return arme2;
    }

    public String toString(){
        return "Arme : " + this.getArme1() + SEP +
                "Arme seconde main : " + this.getArme2() + SEP +
                super.toString();
    }

    public boolean find(Objet objet) {return true; }
}
