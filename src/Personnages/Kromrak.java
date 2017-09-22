package Personnages;

import Interface.KFrame;
import Evenements.Combat;
import Evenements.Salle;
import Objets.Arme;
import com.sun.org.apache.xml.internal.security.utils.SignatureElementProxy;

import java.util.Scanner;

import static Outils.Constantes.SEP;

public class Kromrak extends Personnage {
    Salle salle;
    private Kromrak() {
        this.salle = null;
        inventaire.add(new Arme("Espadon", 1, 2, 1, 5));
        this.arme = (Arme) inventaire.get(0);
        nom = "Kromrak";

        reaction = false;

        //Attributs
        vieMax = 40;
        vie = vieMax;
        vitesse = 2;
        force = 0;
        dextérité = 2;
        endurance = 0;//à faire
        intelligence = 0;//à faire
        CA = 1;

        this.cible = null;
    }

    //best ligne de code ever.
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
            System.out.print(SEP + "Kromrak peux réagir à l'attaque! 1:Esquiver / 2:Contre-attaquer / Autre:économiser la réaction."
                    + SEP + "Faites votre choix : ");
            KFrame.getInstance().textPanel.zoneTexte.addText(SEP + "Kromrak peux réagir à l'attaque! 1:Esquiver / 2:Contre-attaquer / Autre:économiser la réaction."
                    + SEP + "Faites votre choix : ");
            reactionChoisie = Integer.parseInt(scanner.next());
        }

        if (reactionChoisie == 2){
            //TODO:Changer la cible lors de contre-attaque, sinon la mauvaise cible peut être attaquée.
            super.recevoirDegats(nbDegats);
            System.out.println(SEP + this.getNom() + " contre-attaque!");
            KFrame.getInstance().textPanel.zoneTexte.addText(SEP + this.getNom() + " contre-attaque!");
            this.attaquer();
            reaction = false;
        } else if (reactionChoisie == 1){
            System.out.println(this.getNom() + " esquive l'attaque de " + nbDegats + " dommages.");
            KFrame.getInstance().textPanel.zoneTexte.addText(this.getNom() + " esquive l'attaque de " + nbDegats + " dommages.");
            reaction = false;
        } else {
            super.recevoirDegats(nbDegats);
        }
    }

    public void jouerTour(Combat combat) {
        boolean valide;
        Scanner scanner;

        System.out.println(" Au tour de Kromrak!");
        System.out.println("Vos choix: 1. Attaquer");
        System.out.print("Choix : ");
        KFrame.getInstance().textPanel.zoneTexte.addText(" Au tour de Kromrak!" + SEP + "Vos choix: 1. Attaquer" + SEP + "Choix : ");


        do{
            valide = true;
            scanner = new Scanner(System.in);
            switch (scanner.nextLine()){
                case "1":
                    KFrame.getInstance().textPanel.zoneTexte.addText("1");
                    combat.choisirCible();
                    attaquer();
                    break;
                default:
                    valide = false;
                    System.out.print("Choisissez un numéro d'action correct parmis vos choix : ");
                    break;
            }
        } while (!valide);
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Salle getSalle() {
        return salle;
    }
}
