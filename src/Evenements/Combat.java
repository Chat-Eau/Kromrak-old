package Evenements;

import Objets.Objet;
import Personnages.Ennemi;
import Personnages.Kromrak;
import Personnages.Personnage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

import static Outils.Constantes.SEP;

/**
 * Created by lapb290796 on 2017-02-21.
 */
public class Combat {
    private int tour = 1;
    private List<Personnage> personnages = new ArrayList<>();
    private List<Objet> loot = new ArrayList<>();
    private Iterator<Personnage> iterator = personnages.iterator();

    //Mmmm

    private Kromrak kromrak;

    private Combat() {
        this.kromrak = Kromrak.getInstance();
        //TODO: Assigner un numéro à l'ennemi lors de sa création
        this.personnages.removeAll(personnages);
        this.personnages.add(this.personnages.size(), kromrak);


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
    //TODO:GLM: ChoisirCible() doit être refait pour prendre la variable noEnnemi de chaque ennemi, a la place de leur position dans le tableau
    public void choisirCible(){
        int noEnnemi = 0;
        boolean mauvaisChoix = false;
        Scanner scanner = new Scanner(System.in);

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
        //Nouvelle utilité :
        int cpt = 1;
        for (Personnage personnage:personnages) {
            if (personnage.getClass() != Kromrak.class){
                ((Ennemi) personnage).setNoEnnemi(cpt++);
            }
        }

        //Ancienne utilitée (A garder ou pas?) :
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
