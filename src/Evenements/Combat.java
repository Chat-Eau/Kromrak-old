package Evenements;

import Objets.Objet;
import Personnages.Ennemi;
import Personnages.Kromrak;
import Personnages.Personnage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by lapb290796 on 2017-02-21.
 */
public class Combat {
    private int tour = 1;
    private List<Personnage> personnages = new ArrayList<>();
    private List<Objet> loot = new ArrayList<>();
    private Kromrak kromrak;

    public Combat() {
        this.kromrak = Kromrak.getInstance();
        //TODO: Faire une fonction qui parse les ennemis et leur donne des nombres si leur nom est en double?
        //Benjamin: Pas nécessaire pour l'instant. on verra plus tard.

        //TODO: Nommer les ennemis individuellement ne se fait pas lors de la génération aléatoire
        this.personnages.add(this.personnages.size(), kromrak);
        this.personnages.add(this.personnages.size(), new Ennemi("goblin"));
        this.personnages.add(this.personnages.size(), new Ennemi("gnollblin"));
        this.personnages.add(this.personnages.size(), new Ennemi("gnoublin"));
    }

    public void combattre()
    {
        boolean combatFini = false;

        //TODO: A la place de faire jouer le tour des mobs (if (personnage == this.kromrak)),
        //TODO: chaques personnages devraient implémenter les méthodes jouerTour(),
        //TODO: au lieux que ces méthodes soient dans la classe Combat.
        //TODO: personnage.jouerTour()
        short i;
        while (!combatFini) {
            i = 0;
            while (i < personnages.size() && !combatFini) {
                if (personnages.get(i).estVivant() && personnages.get(i).avancerVitesse() == true && !combatFini) {
                    System.out.print(System.lineSeparator() + "Tour " + this.tour++ + " : ");
                    //TODO: personnage.jouerTour();
                    if (personnages.get(i) == this.kromrak) {
                        tourKromrak();
                    } else {
                        tourEnnemi(personnages.get(i));
                    }
                    i++;
                    if (this.verifierEtat() != 0){
                        combatFini = true;
                    }
                }
            }
        }
        finCombat();
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
            switch (scanner.nextLine()){
                case "1":
                    choisirCible();
                    if (this.kromrak.verrifierReaction()) reactionEnnemi(this.kromrak.getCible());
                    this.kromrak.attaquer();
                    if (!this.kromrak.getCible().estVivant()) popPersonnage(this.kromrak.getCible());
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

        for (int i = 1; i < this.personnages.size(); i++){
            if (i != this.personnages.size() && i != 1)
                System.out.print(",                        ");
            if(this.personnages.get(i).estVivant())
                System.out.print(i + ". " + this.personnages.get(i).getNom());
        }
        System.out.println();

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
            } while (noEnnemi < 1 || noEnnemi > this.personnages.size() - 1);
        } while (!this.personnages.get(noEnnemi).estVivant());
        System.out.println();
        this.kromrak.setCible(this.personnages.get(noEnnemi));
    }

    protected int verifierEtat(){
        if (!this.kromrak.estVivant()) return -1;
        for (Personnage personnage:this.personnages)
            if (personnage.estVivant() && personnage != this.kromrak) return 0;
        return 1;
    }

    protected void popPersonnage(Personnage mort) {
        System.out.println(mort.getNom() + " est mort.");

        while (0 < mort.getObjet().size()) {
            if (new Random().nextInt(10) == 0) {
                loot.add((Objet) mort.getObjet().get(0));
            }
            mort.getObjet().remove(0);
        }
        personnages.remove(mort);
    }

    protected void finCombat(){
        if (this.verifierEtat() == -1) {
            System.out.println("Va chier Kromrak.");
        } else if (this.verifierEtat() == 0) {
            System.out.println("Combat en cours.");
        } else {
            System.out.println("Je t'aime, Kromrak!");

            Outils.Outils.mergeArgent(loot);
            kromrak.getObjet().addAll(loot);
            for (Objet objet : loot){
                System.out.println("Vous avez obtenu : " + objet.toString());
            }
            Outils.Outils.mergeArgent(kromrak.getObjet());
        }
    }
}
