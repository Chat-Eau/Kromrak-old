package Personnages;

import Objets.Arme;

/**
 * Created by lapb290796 on 2017-02-21.
 */
public class Kromrak extends Personnage {
    private Kromrak() {
        objets.add(new Arme("Épée longue et dure", 1, 1, 0, 5));
        this.arme = (Arme) objets.get(0);
        nom = "Kromrak";

        parade = false;

        //Attributs
        vieMax = 40;
        vie = vieMax;
        vitesse = 2;
        force = 3;
        dextérité = 1;//à faire
        endurance = 0;//à faire
        intelligence = 0;//à faire
        CA = 1;

        this.cible = null;
    }

    private static Kromrak kromrak = new Kromrak();

    public static Kromrak getInstance() {
        return kromrak;
    }

    public String toString() {
        return super.toString();
    }
}
