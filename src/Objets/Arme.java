package Objets;

import static Outils.Outils.lancerDes;

/**
 * Created by lapb290796 on 2017-02-21.
 */
public class Arme extends Equipement {
    private int nbDés;
    private int multiplicateur;
    private int dmgBase;

    public Arme () {
        this.nbDés = 1;
        this.dmgBase = -1;
        this.multiplicateur = 1;
        this.nom = "Epée courte et molle";
        this.valeur = 3;
    }

    public Arme (String nom, int nbDés, int dmgBase,int modificateur, int valeur) {
        super(nom, valeur);
        this.nbDés = nbDés;
        this.dmgBase = dmgBase;
        this.multiplicateur = modificateur;
    }

    public int getDegats() {
        return (lancerDes(nbDés) + dmgBase) * multiplicateur;
    }

    public String toString(){
        return nom + " : dommages de " + nbDés + "D4, " + dmgBase + (multiplicateur != 1 ? " * " + multiplicateur : "");
    }
}

