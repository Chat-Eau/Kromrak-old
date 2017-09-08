package Evenements;

import Conteneur.Conteneur;
import Objets.Objet;
import Personnages.Ennemi;
import Personnages.Kromrak;
import Personnages.Personnage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static Outils.Constantes.SEP;
import static Outils.Outils.choixNumerique;

public class Combat extends Evenement{
    private int tour = 1;
    private List<Personnage> personnages = new ArrayList<>();
    private Conteneur loot = new Conteneur("loot de fin de combat");

    private Kromrak kromrak;

    public Combat() {
        this.tour = 1;
        this.description = "Deux méchants très menacants attaque Kromrak! Oh! Il y a un caca aussi!";
        this.kromrak = Kromrak.getInstance();
        this.personnages.removeAll(personnages);
        this.personnages.add(this.personnages.size(), kromrak);
        this.auto = true;

        try {
            Scanner scanner = new Scanner(new FileInputStream("src\\fichierEnnemi"));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.charAt(0) != '/'){
                    personnages.add(new Ennemi(line));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assignerNbrEnnemi();
    }

    public void activer() throws InterruptedException {
        System.out.println(this + SEP);

        int etat = this.verifierEtat();

        while (etat == 0) {
            Thread.sleep(50);
            for (int i = 0; i < personnages.size(); i++)  {
                if (personnages.get(i).avancerVitesse()) {
                    System.out.print(SEP + "Tour " + this.tour++ + " : ");
                    personnages.get(i).jouerTour(this);
                    if ((etat = this.verifierEtat()) != 0){
                        break;
                    }
                    Thread.sleep(1500);
                }
            }
        }
        finCombat(etat);
    }

    //TODO:GLM: ChoisirCible() doit être refait pour prendre la variable noEnnemi de chaque ennemi, a la place de leur position dans le tableau
    public void choisirCible(){
        int noEnnemi = 0;

        System.out.print(SEP + "Choisisser votre cible :         ");

        for (int i = 1; i < this.personnages.size(); i++){
            if (i != this.personnages.size() && i != 1)
                System.out.print("         ");
            System.out.print((i) + ". " + this.personnages.get(i).getNom() + " lvl " + this.personnages.get(i).getLvl());
        }

        System.out.print(SEP + "Faites votre choix : ");

        noEnnemi = choixNumerique(1, this.personnages.size() - 1);

        this.kromrak.setCible(this.personnages.get(noEnnemi));
    }

    //Return -1 : Kromrak mort
    //Return 0 : Combat en cours
    //Return 1 : Combat gagné
    protected int verifierEtat(){
        if (!this.kromrak.estVivant()) return -1;

        int etat = 1;
        for(int i = 0; i <personnages.size(); i++){
            if (personnages.get(i).getNom()!="Kromrak") {
                if (personnages.get(i).estVivant())
                    etat = 0;
                else {
                    pop(i--);
                }
            }
        }

        return etat;
    }

    protected void finCombat(int etat){
        if (etat == -1) {
            System.out.println(SEP + "Va chier Kromrak.");
        } else if (etat == 0) {
            System.out.println(SEP + "Combat en cours.");
        } else {
            System.out.println(SEP + "Je t'aime, Kromrak!");
            System.out.println("Vous avez obtenu : " + loot.toString() + SEP);
            loot.addAll(kromrak.getObjets());
        }
        Kromrak.getInstance().resetBarres();
    }

    public void pop(int noEnnemi) {
        System.out.println(this.personnages.get(noEnnemi).getNom() + " est mort.");

        this.loot.add(this.personnages.get(noEnnemi).getInventaire().getPiece());
        this.loot.rndAdd(this.personnages.get(noEnnemi).getInventaire());

        this.personnages.remove(noEnnemi);
    }

    public void assignerNbrEnnemi(){
        int cpt = 1;
        for (Personnage personnage:personnages) {
            if (personnage.getClass() != Kromrak.class){
                ((Ennemi) personnage).setNoEnnemi(cpt++);
            }
        }
    }
}
