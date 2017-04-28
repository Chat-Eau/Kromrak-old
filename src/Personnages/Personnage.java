package Personnages;


import Evenements.Combat;
import Objets.Arme;
import Objets.Objet;
import Outils.Outils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by lapb290796 on 2017-02-21.
 */
public class Personnage {
    protected Arme arme;
    protected String nom;
    protected List<Objet> objets = new ArrayList<>();

    //TODO: Cible? Pourquoi personnage a besoin d'un personnage cible?
    //TODO: La cible devrait etre le paramètre d'une fonction attaquer, pas une variable.
    protected Personnage cible;

    protected boolean reaction = false;

    private int barreVitesse = 0;
    private int barreReaction = 0;
    //Attributs
    //TODO: Une classe pour chaque attribut?
    //TODO: Pour séparer les get/set, les gérer individuellement pour les caps...
    protected int vieMax;
    protected int vie;
    protected int vitesse = 0;
    protected int force = 0;
    protected int dextérité = 0;//à faire
    protected int endurance = 0;//à faire
    protected int intelligence = 0;//à faire
    protected int CA = 1;

    static public final int STEP_VITESSE = 3;

    protected Personnage() {}

    public void recevoirDegats (int nbDegats)
    {
        int degats = Outils.minCap(nbDegats - CA, 1);

        System.out.print(this.nom + " a reçu: " + degats + " dégats." + System.lineSeparator());

        avancerReaction();
        this.vie -= degats;

        vie = Outils.minMaxCap(vie, 0, vieMax);

        if (this.vie == 0) {
            this.pop();
        }
    }

    public int attaquer() {
        int degats = 0;
        if (this.arme != null) {
            degats = arme.getDegats();
        }

        cible.recevoirDegats(Outils.minCap((degats + force - cible.CA), 1));

        return degats;
    }

    public void gagnerVie (int nbVie) {
        this.vie = Outils.maxCap(nbVie + this.vie, vieMax);
    }

    public void setArme (Arme arme)
    {
        this.arme = arme;
    }

    public String toString () {
        String sep = System.lineSeparator();
        String strObjets = "";
        for (int i = 0; i < objets.size(); i++){
            strObjets += objets.get(i).toString();
            if (i != objets.size() - 1){
                strObjets += sep;
            }
        }
        return "Nom: " + nom + sep +
                "Vie: " + this.vie + "/" + this.vieMax + sep +
                "Arme: " + this.arme.toString() + sep +
                "Vitesse: " + vitesse + sep +
                "Force: " + force + sep +
                "Dextérité: " + dextérité + sep +
                "Endurance: " + endurance + sep +
                "Intelligence: " + intelligence + sep +
                "Classe d'armure: " + CA + sep + sep +
                "Inventaire: " + sep +
                strObjets;
    }

    public boolean avancerVitesse() {
        this.barreVitesse += STEP_VITESSE + vitesse;

        if (this.barreVitesse >= 100) {
            this.barreVitesse -= 100;
            return true;
        } else {
            return false;
        }
    }

    public void avancerReaction() {
        if (!reaction) {
            this.barreReaction += 5 + dextérité;
            if (this.barreReaction >= 100) {
                this.barreReaction -= 100;
                reaction = true;
            }
        }
    }

    public boolean estVivant() { return vie > 0; }

    public Personnage getCible() { return cible; }

    public String getNom() { return this.nom; }

    public Arme getArme() {
        return arme;
    }

    public int getVitesse() {
        return vitesse;
    }

    public int getDextérité() {
        return dextérité;
    }

    public int getForce() {
        return force;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getVie() {
        return vie;
    }

    public int getVieMax() {
        return vieMax;
    }

    public List getObjets() {
        return objets;
    }

    public void activerParade() { reaction = true; }

    public void setCible(Personnage cible) {this.cible = cible; }

    protected void pop() {
        System.out.println(this.nom + " est mort.");

        if (this != Kromrak.getInstance()) {
            while (0 < this.objets.size()) {
                if (new Random().nextInt(10) == 0) {
                    Combat.loot.add((Objet) this.objets.get(0));
                }
                this.objets.remove(0);
            }
        }
        Combat.personnages.remove(this);
    }
}