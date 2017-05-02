package Evenements;

import Objets.Objet;
import Outils.Constantes;
import Personnages.Ennemi;
import Personnages.Kromrak;
import Personnages.Personnage;

import java.util.*;

import static Outils.Constantes.SEP;

//TODO:GLM: Constant "SEP" qui remplace "System.LineSeparator()"?
/**
 * Created by lapb290796 on 2017-02-21.
 */
public class Combat {
    private int tour = 1;
    private List<Personnage> personnages = new ArrayList<>();
    private List<Objet> loot = new ArrayList<>();
    private Iterator<Personnage> iterator = personnages.iterator();

    private Kromrak kromrak;

    private Combat() {
        this.kromrak = Kromrak.getInstance();
        //TODO: Faire une fonction qui parse les ennemis et leur donne des nombres si leur nom est en double?

        //TODO: Nommer les ennemis individuellement ne se fait pas lors de la génération aléatoire
        this.personnages.removeAll(personnages);
        this.personnages.add(this.personnages.size(), kromrak);
        this.personnages.add(this.personnages.size(), new Ennemi("goblin 1"));
        this.personnages.add(this.personnages.size(), new Ennemi("goblin 2"));
        this.personnages.add(this.personnages.size(), new Ennemi("goblin 3"));
    }

    private static Combat combat = null;

    public static Combat getInstance() {
        return combat;
    }

    public static Combat newCombat() {
        return combat = new Combat();
    }

    public void combattre()
    {
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
    public void choisirCible(){
        int noEnnemi = 0;
        boolean mauvaisChoix = false;
        Scanner scanner = new Scanner(System.in);

        System.out.print(SEP + "Choisisser votre cible :         ");

        for (int i = 1; i < this.personnages.size(); i++){
            if (i != this.personnages.size() && i != 1)
                System.out.print(",         ");
            if(this.personnages.get(i).estVivant())
                System.out.print(i + ". " + this.personnages.get(i).getNom());
        }

        System.out.print(SEP + "Faites votre choix : ");

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

        for (int i = 0; i < personnages.size(); i++) {
            if (personnages.get(i).estVivant() && personnages.get(i) != this.kromrak) return 0;
        }

        return 1;
    }

    protected void finCombat(){
        if (this.verifierEtat() == -1) {
            System.out.println(SEP + "Va chier Kromrak.");
        } else if (this.verifierEtat() == 0) {
            System.out.println(SEP + "Combat en cours.");
        } else {
            System.out.println(SEP + "Je t'aime, Kromrak!");

            Outils.Outils.mergeArgent(loot);
            kromrak.getObjets().addAll(loot);
            for (Objet objet : loot){
                System.out.println("Vous avez obtenu : " + objet.toString());
            }
            System.out.println();
            Outils.Outils.mergeArgent(kromrak.getObjets());
        }
    }

    public void lootAdd(Objet objet) {
        loot.add(objet);
    }

    public void personnagesRemove(Personnage personnage) {
        personnages.remove(personnage);
    }
}
