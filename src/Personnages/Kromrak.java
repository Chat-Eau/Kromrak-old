package Personnages;

import Evenements.Combat;
import Objets.Arme;

import java.util.Scanner;

/**
 * Created by lapb290796 on 2017-02-21.
 */
public class Kromrak extends Personnage {
    private Kromrak() {
        objets.add(new Arme("Épée longue et dure", 1, 1, 0, 5));
        this.arme = (Arme) objets.get(0);
        nom = "Kromrak";

        reaction = false;

        //Attributs
        vieMax = 40;
        vie = vieMax;
        vitesse = 2;
        force = 3;
        dextérité = 1;//à faire
        endurance = 0;//à faire
        intelligence = 0;//à faire
        CA = 0;

        this.cible = null;
    }

    private static Kromrak kromrak = new Kromrak();

    public static Kromrak getInstance() {
        return kromrak;
    }

    public String toString() {
        return super.toString();
    }

    public void recevoirDegats (int nbDegats)
    {
        super.recevoirDegats(nbDegats);
        if (reaction){
            //TODO:GLM: Kromrak peut réagir
        }
    }

    public void jouerTour() {
        boolean valide;
        Scanner scanner;

        System.out.println(" Au tour de Kromrak!");
        System.out.println("Vos choix: 1. Attaquer");
        System.out.print("Choix : ");

        do{
            valide = true;
            scanner = new Scanner(System.in);
            switch (scanner.nextLine()){
                case "1":
                    Combat.getInstance().choisirCible();
                    attaquer();
                    break;
                default:
                    valide = false;
                    System.out.print("Choisissez un numéro d'action correct parmis vos choix : ");
                    break;
            }
        } while (!valide);
    }

}
