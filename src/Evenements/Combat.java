package Evenements;

import Personnages.Ennemi;
import Personnages.Kromrak;
import Personnages.Personnage;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by lapb290796 on 2017-02-21.
 */
public class Combat {
    private int tour = 1;
    private Personnage[] personnages;
    private Kromrak kromrak;

    public Combat() {
        this.kromrak = Kromrak.getInstance();
        //TODO: Faire une fonction qui parse les ennemis et leur donne des nombres si leur nom est en double?
        //Benjamin: Pas nécessaire pour l'instant. on verra plus tard.

        //TODO: Nommer les ennemis individuellement ne se fait pas lors de la génération aléatoire
        this.personnages = new Personnage[]{kromrak, new Ennemi("goblin"), new Ennemi("goblin")};
    }

    public void combattre()
    {
        boolean combatFini = false;
        //TODO: ordreTour() est VRAIMENT inutile, les enemis sont triés de toute manière.
        ordreTour();

        //TODO: A la place de faire jouer le tour des mobs (if (personnage == this.kromrak)),
        //TODO: chaques personnages devraient implémenter les méthodes jouerTour(),
        //TODO: au lieux que ces méthodes soient dans la classe Combat.
        //TODO: personnage.jouerTour()

        while (!combatFini) {
            for (Personnage personnage : this.personnages) {
                if (personnage.estVivant() && personnage.avancerVitesse() == true && !combatFini) {
                    System.out.print(System.lineSeparator() + "Tour " + this.tour++ + " : ");
                    //TODO: personnage.jouerTour();
                    if (personnage == this.kromrak) {
                        tourKromrak();
                    } else {
                        tourEnnemi(personnage);
                    }

                    if (this.verifierEtat() != 0){
                        combatFini = true;
                    }
                }
            }
        }
        //TODO: Créer une méthode qui gère les fins de combats?
        //TODO: OU retourner l'état du combat, vu que le message de fin/loot/etc ne fais techniquement pas partie d'un combat
        System.out.println(this.verifierEtat() < 1 ? "Va chier Kromrak." : "Je t'aime, Kromrak!");
    }



    protected void tourKromrak(){
        boolean valide;
        Scanner scanner;

        System.out.println(" Au tour de Kromrak!");
        System.out.println("Vos choix: 1. Attaquer");
        System.out.print("Choix : ");

        do{
            valide = true;
            scanner = new Scanner(System.in);
            switch (scanner.nextLine()){//choix){
                case "1":
                    choisirCible();
                    if (this.kromrak.verrifierReaction() > 0) reactionEnnemi(this.kromrak.getCible());
                    this.kromrak.attaquer();
                    if (!this.kromrak.getCible().estVivant()) afficherMort(this.kromrak.getCible());
                    break;
                default:
                    valide = false;
                    System.out.print("Choisissez un numéro d'action correct parmis vos choix : ");
                    break;
            }
        } while (!valide);
    }

    protected void reactionEnnemi(Personnage ennemi) {
        if (new Random().nextInt(3) == 0) {
            System.out.print(ennemi.getNom() + " bloque l'attaque et ");
            ennemi.activerParade();
        } else {
            System.out.println(ennemi.getNom() + " contre-attaque!" + System.lineSeparator());
            ennemi.attaquer();
        }
    }

    protected void tourEnnemi(Personnage ennemi){
        System.out.println("Au tour de : " + ennemi.getNom());
        ennemi.attaquer();
    }

    protected void choisirCible(){
        int noEnnemi = 0;
        boolean mauvaisChoix = false;
        Scanner scanner;

        System.out.print(System.lineSeparator() + "Choisisser votre cible :     ");

        for (int i = 1; i < this.personnages.length; i++){
            if (i != this.personnages.length && i != 1)
                System.out.print(",                        ");
            if(this.personnages[i].estVivant())
                System.out.print(i + ". " + this.personnages[i].getNom());
        }
        System.out.println();


        //TODO:GLM: Sa serais pas mieux de faire une fonction qui pop les ennemis?
        //TODO:GLM: La fonction pop pourrais potentiellement les détruire, mais ajouter leur loot
        //TODO:GLM: à une variable de la classe combat "Loot"?
        scanner = new Scanner(System.in);

        System.out.print("Faites votre choix : ");
        do{
            do{
                if (mauvaisChoix){
                    System.out.print("Vous devez cibler un ennemi existant :");
                } else {
                    mauvaisChoix = true;
                }
                while (!scanner.hasNextInt()){
                    System.out.print("Vous devez choisir un nombre : ");
                    scanner.next();
                }
                noEnnemi = scanner.nextInt();
            } while (noEnnemi < 1 || noEnnemi > this.personnages.length - 1);
        } while (!this.personnages[noEnnemi].estVivant());
        System.out.println();
        this.kromrak.setCible(this.personnages[noEnnemi]);
    }

    protected int verifierEtat(){
        if (!this.kromrak.estVivant()) return -1;
        for (Personnage personnage:this.personnages)
            if (personnage.estVivant() && personnage != this.kromrak) return 0;
        return 1;
    }

    protected void afficherMort(Personnage mort) {
        System.out.println(this.kromrak.getCible().getNom() + " est mort.");
    }

    protected void ordreTour() {
        Personnage tampon;
        for (int i = this.personnages.length; i > 1; i--) {
            tampon = this.personnages[1];
            for (int j = 2; j < i; j++) {
                if (tampon.getVitesse() > this.personnages[j].getVitesse()) {
                    tampon = this.personnages[j];
                } else {
                    this.personnages[j - 1] = this.personnages[j];
                    this.personnages[j] = tampon;
                }
            }
        }
    }
}
