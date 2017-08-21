package Personnages;

import Evenements.Combat;
import Objets.Arme;

import java.util.Scanner;

import static Outils.Constantes.SEP;

/**
 * Created by lapb290796 on 2017-02-21.
 */
public class Kromrak extends Personnage {
    private Kromrak() {
        inventaire.add(new Arme("Espadon", 1, 2, 1, 5));
        this.arme = (Arme) inventaire.get(0);
        nom = "Kromrak";

        reaction = false;

        //Attributs
        vieMax = 40;
        vie = vieMax;
        vitesse = 2;
        force = 0;
        dextérité = 5;
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

    public void recevoirDegats (int nbDegats)
    {
        Scanner scanner = new Scanner(System.in);

        int reactionChoisie = -1;
        if (reaction){
            System.out.println(SEP + "Kromrak peux réagir à l'attaque! 1:Esquiver / 2:Contre-attaquer / Autre:économiser la réaction.");
            System.out.print("Faites votre choix : ");
            reactionChoisie = Integer.parseInt(scanner.next());
        }

        if (reactionChoisie == 2){
            super.recevoirDegats(nbDegats);
            System.out.println(SEP + this.getNom() + " contre-attaque!");
            this.attaquer();
            reaction = false;
        } else if (reactionChoisie == 1){
            System.out.println(this.getNom() + " esquive l'attaque de " + nbDegats + " dommages.");
            reaction = false;
        } else {
            super.recevoirDegats(nbDegats);
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
