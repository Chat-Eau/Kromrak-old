package Conteneur;

import Objets.Arme;
import Objets.Equipment;
import Objets.Objet;

import java.util.ArrayList;
import java.util.List;

public class Inventaire extends Conteneur{
    //0:Chest, 1:Head, 2:Feet, 3:Hands, 4:Legs, 5:Finger1,
    //6:Finger2, 7:Neck, 8:Accessory1, 9:Accessory2, 10:Accessory3
    private List<Equipment> equipment = new ArrayList<>();
    private List<Arme> weapons = new ArrayList<>();

    public Inventaire(String nom){
        super(nom, 0);
    }
    public Inventaire(String newName, Inventaire copiedInv){
        super(newName, copiedInv.getObjets(), 0);
        this.equipment = copiedInv.equipment;
        this.weapons = copiedInv.weapons;
    }

    public void equip(Arme weapon) {
        if (false) {
            //TODO:Vérifier les conditions d'équipement
            return;
        }
        for (Equipment slot: equipment) {
            if (slot.getType() == weapon.getType()){
                unequip(slot);
                break;
            }
        }
        weapon.setEquiped(true);
        this.getObjets().remove(weapon);
        equipment.add(weapon);
    }
    public void equip(Equipment equipment) {
        if (false) {
            //TODO:Vérifier les conditions d'équipement
            return;
        }
        for (Equipment slot: this.equipment) {
            if (slot.getType() == equipment.getType()){
                unequip(slot);
                break;
            }
        }
        equipment.setEquiped(true);
        this.getObjets().remove(equipment);
        this.equipment.add(equipment);
    }

    public void unequip(Arme weapon){
        weapon.setEquiped(false);
        this.getObjets().add(weapon);
        equipment.remove(weapon);
    }
    public void unequip(Equipment equipment){
        equipment.setEquiped(false);
        this.getObjets().add(equipment);
        this.equipment.remove(equipment);    }

    public String toString(){
        return super.toString();
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
