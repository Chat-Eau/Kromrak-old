package Conteneur;

import Objets.Arme;
import Objets.Equipement;
import Objets.Objet;

import java.util.ArrayList;
import java.util.List;

import static Outils.Constantes.SEP;

public class Inventaire extends Conteneur{
    public Inventaire(String nom){
        super(nom, 0);
    }
    public Inventaire(String newName, Inventaire copiedInv){
        super(newName, copiedInv.getObjets(), 0);
        this.equipements = copiedInv.equipements;
        this.weapons = copiedInv.weapons;
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
            if (slot.getType() == weapon.getType()){
                unequip(slot);
                break;
            }
        }
        weapon.setEquiped(true);
        this.getObjets().remove(weapon);
        equipements.add(weapon);
    }
    public void equip(Equipement equipment) {
        if (false) {
            //TODO:Vérifier les conditions d'équipement
            return;
        }
        for (Equipement slot:equipements) {
            if (slot.getType() == equipment.getType()){
                unequip(slot);
                break;
            }
        }
        equipment.setEquiped(true);
        this.getObjets().remove(equipment);
        equipements.add(equipment);
    }

    public void unequip(Arme weapon){
        weapon.setEquiped(false);
        this.getObjets().add(weapon);
        equipements.remove(weapon);
    }
    public void unequip(Equipement equipment){
        equipment.setEquiped(false);
        this.getObjets().add(equipment);
        equipements.remove(equipment);    }

    public String toString(){
        return super.toString();
    }

    public List<Arme> getWeapons() {
        return weapons;
    }
    public List<Equipement> getEquipements() {
        return equipements;
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
