package Evenements;

import Objets.Objet;
import Personnages.Ennemi;
import Personnages.Kromrak;
import Personnages.Personnage;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static Outils.Constantes.SEP;

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
        //TODO: Assigner un numéro à l'ennemi lors de sa création
        this.personnages.removeAll(personnages);
        this.personnages.add(this.personnages.size(), kromrak);

        try {
            Scanner scanner = new Scanner(new FileInputStream("C:\\Users\\LAMG030499\\Documents\\GitHub\\Kromrak\\src\\fichierEnnemi"));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                personnages.add(new Ennemi(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.personnages.add(this.personnages.size(), new Ennemi());
        this.personnages.add(this.personnages.size(), new Ennemi());
        this.personnages.add(this.personnages.size(), new Ennemi());
        assignerNbrEnnemi();
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
                System.out.print("         ");
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

    public void assignerNbrEnnemi(){
//        for (Personnage personnage1:personnages) {
//            String nom1 = personnage1.getNom();
//            short cptSimilaire = 1;
//            for (Personnage personnage2:personnages) {
//                if (nom1.equals(personnage2.getNom()) && personnage1 != personnage2){
//                    personnage2.setNom(nom1 + " " + (++cptSimilaire));
//                }
//            }
//            if(cptSimilaire > 1){
//                personnage1.setNom(nom1 + " 1");
//            }
//        }
    }
}
