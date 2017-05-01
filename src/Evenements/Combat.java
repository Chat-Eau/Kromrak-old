package Evenements;

import Objets.Objet;
import Personnages.Ennemi;
import Personnages.Kromrak;
import Personnages.Personnage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TODO:GLM: Constant "SEP" qui remplace "System.LineSeparator()"?
/**
 * Created by lapb290796 on 2017-02-21.
 */
public class Combat {
    public static int tour = 1;
    public static List<Personnage> personnages = new ArrayList<>();
    public static List<Objet> loot = new ArrayList<>();
    public static Kromrak kromrak;

    private Combat() {
        this.kromrak = Kromrak.getInstance();
        //TODO: Faire une fonction qui parse les ennemis et leur donne des nombres si leur nom est en double?
        //Benjamin: Pas nécessaire pour l'instant. on verra plus tard.

        //TODO: Nommer les ennemis individuellement ne se fait pas lors de la génération aléatoire
        this.personnages.removeAll(personnages);
        this.personnages.add(this.personnages.size(), kromrak);
        this.personnages.add(this.personnages.size(), new Ennemi("goblin"));
        this.personnages.add(this.personnages.size(), new Ennemi("gnollblin"));
        this.personnages.add(this.personnages.size(), new Ennemi("gnoublin"));
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

        //TODO:GLM: Ben faut tester avant + après tes modifications. La boucle for plante après un pop.
//        short i;
//        while (!combatFini) {
//            for (Personnage personnage: personnages)  {
//                if (personnage.avancerVitesse()) {
//                    System.out.print(System.lineSeparator() + "Tour " + this.tour++ + " : ");
//                    personnage.jouerTour();
//                    if (this.verifierEtat() != 0){
//                        combatFini = true;
//                        break;
//                    }
//                }
//            }
//        }
        short i;
        while (!combatFini) {
            i = 0;
                while (i < personnages.size() && !combatFini) {
                    if (personnages.get(i).estVivant() && personnages.get(i).avancerVitesse() == true && !combatFini) {
                        System.out.print(System.lineSeparator() + "Tour " + this.tour++ + " : ");
                        personnages.get(i).jouerTour();
                        if (this.verifierEtat() != 0) {
                            combatFini = true;
                        }
                    }
                    i++;
                }
            }
        finCombat();
    }

    //Je laisse choisirCiblie() ici, c'est un peu moins compliquer
    public void choisirCible(){
        int noEnnemi = 0;
        boolean mauvaisChoix = false;
        Scanner scanner = new Scanner(System.in);

        System.out.print(System.lineSeparator() + "Choisisser votre cible :         ");

        for (int i = 1; i < this.personnages.size(); i++){
            if (i != this.personnages.size() && i != 1)
                System.out.print(",         ");
            if(this.personnages.get(i).estVivant())
                System.out.print(i + ". " + this.personnages.get(i).getNom());
        }

        System.out.print(System.lineSeparator() + "Faites votre choix : ");

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
        for (Personnage personnage:this.personnages) {
            if (personnage.estVivant() && personnage != this.kromrak) return 0;
            else if (personnage != this.kromrak)
                personnage.pop();
        }

        return 1;
    }

    protected void finCombat(){
        if (this.verifierEtat() == -1) {
            System.out.println(System.lineSeparator() + "Va chier Kromrak.");
        } else if (this.verifierEtat() == 0) {
            System.out.println(System.lineSeparator() + "Combat en cours.");
        } else {
            System.out.println(System.lineSeparator() + "Je t'aime, Kromrak!");

            Outils.Outils.mergeArgent(loot);
            kromrak.getObjets().addAll(loot);
            for (Objet objet : loot){
                System.out.println("Vous avez obtenu : " + objet.toString());
            }
            System.out.println();
            Outils.Outils.mergeArgent(kromrak.getObjets());
        }
    }
}
