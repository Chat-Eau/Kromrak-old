package Personnages;


import Objets.Arme;
import Objets.Objet;
import Outils.Outils;

import java.util.ArrayList;
import java.util.List;

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

    protected boolean parade = false;

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
        int degats = (this.parade == true)?nbDegats-1-this.CA:nbDegats;
        degats = (degats > 0)?degats:1;
        this.parade = false;

        System.out.print(this.nom + " a reçu: " + degats + " dégats." + System.lineSeparator());

        this.barreReaction += dextérité + 5;
        this.vie -= degats;

        Outils.maxCap(vie, vieMax);
    }

    public int attaquer()
    {
        int degats = this.arme.getDegats();

        cible.recevoirDegats(Outils.minCap((degats + force - cible.CA), 1));

        return degats;
    }

    public void gagnerVie (int nbVie)
    {
        this.vie += nbVie;
        if (this.vie > vieMax)
        {
            this.vie = vieMax;
        }
    }

    public void setArme (Arme arme)
    {
        this.arme = arme;
    }

    public void afficherEtat () {
        System.out.println("vie:" + this.vie + "/" + this.vieMax);
        System.out.println("Votre arme est : " + arme.toString());
    }

    public boolean avancerVitesse() {
        this.barreVitesse += STEP_VITESSE + vitesse;

        if (this.barreVitesse >= 100) {
            this.barreVitesse -= 100;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean verrifierReaction() {
        if (this.barreReaction >= 100) {
            this.barreReaction -= 100;
            return true;
        } else {
            return false;
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

    public List getObjet() {
        return objets;
    }

    public void activerParade() { parade = true; }

    public void setCible(Personnage cible) {this.cible = cible; }

}