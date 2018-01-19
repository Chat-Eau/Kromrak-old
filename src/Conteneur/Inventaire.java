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

    //0:Chest, 1:Head, 2:Feet, 3:Hands, 4:Legs, 5:Finger1,
    //6:Finger2, 7:Neck, 8:Accessory1, 9:Accessory2, 10:Accessory3
    private List<Equipement> equipements = new ArrayList<>();
    private List<Arme> weapons = new ArrayList<>();

    public void equip(Arme weapon) {
        if (false) {
            //TODO:Vérifier les conditions d'équipement
            return;
        }
        for (Equipement slot:equipements) {
            if (slot.getType() == equipment.getType()){
                equipment.setEquiped(false);
                this.getObjets().add(equipment);
                unequip(equipment);
                break;
            }
        }
        equipment.setEquiped(true);
        this.getObjets().remove(equipment);
        equipements.add(equipment);
    }
    public void equip(Equipement equipment) {
        if (false) {
            //TODO:Vérifier les conditions d'équipement
            return;
        }
        for (Equipement slot:equipements) {
            if (slot.getType() == equipment.getType()){
                equipment.setEquiped(false);
                this.getObjets().add(equipment);
                unequip(equipment);
                break;
            }
        }
        equipment.setEquiped(true);
        this.getObjets().remove(equipment);
        equipements.add(equipment);
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

    public boolean find(Objet object) {
        for (Objet invObject:this.getObjets()) {
            if (invObject == object){
                return true;
            }
        }
        return false;
    }
}
