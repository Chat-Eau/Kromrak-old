package Objets;

import static Outils.Outils.lancerDes;

public class Arme extends Equipment {
    private int nbDés;
    private int multiplicateur;
    private int dmgBase;

    public Arme (String nom, int nbDés, int dmgBase,int multiplicateur, int valeur, String type) {
        super(nom, valeur, type);
        this.nbDés = nbDés;
        this.dmgBase = dmgBase;
        this.multiplicateur = multiplicateur;
    }

    public int getDegats() {
        return (lancerDes(nbDés) + dmgBase) * multiplicateur;
    }

    public String toString(){
        if(this != null)
        return nom + " : dommages de " + nbDés + "D4, " + dmgBase + (multiplicateur != 1 ? " * " + multiplicateur : "");
        return "Aucune arme";
    }
}

