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
import java.util.Scanner;

import static Outils.Constantes.SEP;
import static Outils.Outils.choixNumerique;

/**
 * Created by lapb290796 on 2017-02-21.
 */
public class Combat extends Evenement{
    private int tour = 1;
    private List<Personnage> personnages = new ArrayList<>();
    private Conteneur loot = new Conteneur("loot de fin de combat");

    private Kromrak kromrak;

    private Combat() {
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

    private static Combat combat = null;

    public static Combat getInstance() {
        return combat;
    }

    public static Combat newCombat() {
        return combat = new Combat();
    }
    public static Combat setCombat(Combat nouveauCombat) { return combat = nouveauCombat; }

    public void activer()
    {
        super.activer();

        boolean combatFini = false;

        while (!combatFini) {
            for (int i = 0; i < personnages.size(); i++)  {
                if (personnages.get(i).avancerVitesse()) {
                    System.out.print(SEP + "Tour " + this.tour++ + " : ");
                    personnages.get(i).jouerTour();
                    if (this.verifierEtat() != 0){
                        combatFini = true;
                        break;
                    }
                }
            }
        }
        finCombat();
    }

    //BL: Je laisse choisirCiblie() ici, c'est un peu moins compliquer
    //TODO:GLM: ChoisirCible() doit être refait pour prendre la variable noEnnemi de chaque ennemi, a la place de leur position dans le tableau
    public void choisirCible(){
        int noEnnemi = 0;

        System.out.print(SEP + "Choisisser votre cible :         ");

        for (int i = 1; i < this.personnages.size(); i++){
            if (i != this.personnages.size() && i != 1)
                System.out.print("         ");
            System.out.print((i) + ". " + this.personnages.get(i).getNom() + " lvl " + this.personnages.get(i).getLvl());
            //TODO:GLM: Décomenter le sout en dessous lorsque choisirCible choisit selon le numéro de l'ennemi, pas sa position dans le tableau.

//          System.out.print(((Ennemi)this.personnages.get(i)).getNoEnnemi() + ". "
//                  + this.personnages.get(i).getNom() + " " + this.personnages.get(i).getLvl());
        }

        System.out.print(SEP + "Faites votre choix : ");

        noEnnemi = choixNumerique(1, this.personnages.size() - 1);

        System.out.println();
        this.kromrak.setCible(this.personnages.get(noEnnemi));
    }

    //Return -1 : Kromrak mort
    //Return 0 : Combat en cours
    //Return 1 : Combat gagné
    protected int verifierEtat(){
        if (!this.kromrak.estVivant()) return -1;
        if (personnages.size() > 1) return 0;
        return 1;
    }

    protected void finCombat(){
        if (this.verifierEtat() == -1) {
            System.out.println(SEP + "Va chier Kromrak.");
        } else if (this.verifierEtat() == 0) {
            System.out.println(SEP + "Combat en cours.");
        } else {
            System.out.println(SEP + "Je t'aime, Kromrak!");
            System.out.println("Vous avez obtenu : " + loot.toString() + SEP);
            loot.addAll(kromrak.getObjets());
        }
        Kromrak.getInstance().resetBarres();
        combat = null;
    }

    public void lootAdd(Objet objet) {
        loot.add(objet);
    }
    public void lootAdd(int i) {
        loot.add(i);
    }

    public void personnagesRemove(Personnage personnage) {
        personnages.remove(personnage);
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
