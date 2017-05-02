package Personnages;


import Objets.Arme;
import Objets.Objet;
import Outils.Outils;

import java.util.ArrayList;
import java.util.List;

import static Outils.Constantes.SEP;

/**
 * Created by lapb290796 on 2017-02-21.
 */
public abstract class Personnage {
    protected Arme arme;
    protected String nom;
    protected int lvl;
    protected List<Objet> objets = new ArrayList<>();

    //TODO: La cible devrait etre le paramètre d'une fonction attaquer, pas une variable, non?
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
    static public final int STEP_REACTION = 5;

    static public final int MAX_REACTION = 100;
    static public final int MAX_VITESSE = 100;

    protected Personnage() {}

    public void recevoirDegats (int nbDegats)
    {
        int degats = Outils.minCap(nbDegats - CA, 1);

        System.out.print(this.nom + " a reçu: " + degats + " dégats." + SEP);

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

    public void setArme (Arme arme) {
        this.arme.setEquipé(false);
        arme.setEquipé(true);
        this.arme = arme;
    }

    //BL: Un jouerTour() abstrait pour pouvoir l'appeler à partir du tableau de personnages
    public abstract void jouerTour();

    public String toString () {
        String strObjets = "";
        for (int i = 0; i < objets.size(); i++){
            if (objets.get(i).getEquipé() == false) {
                strObjets += objets.get(i).toString();
                if (i != objets.size() - 1) {
                    strObjets += SEP;
                }
            }
        }

        return "Nom: " + nom + SEP +
                "Vie: " + this.vie + "/" + this.vieMax + SEP +
                "Arme: " + this.arme.toString() + SEP +
                "Vitesse: " + vitesse + SEP +
                "Force: " + force + SEP +
                "Dextérité: " + dextérité + SEP +
                "Endurance: " + endurance + SEP +
                "Intelligence: " + intelligence + SEP +
                "Classe d'armure: " + CA + SEP + SEP +
                "Inventaire: " + SEP +
                strObjets;
    }

    public boolean avancerVitesse() {
        this.barreVitesse += STEP_VITESSE + vitesse;

        if (this.barreVitesse >= MAX_VITESSE) {
            this.barreVitesse -= MAX_VITESSE;
            return true;
        } else {
            return false;
        }
    }

    public Boolean avancerReaction() {
        if (!reaction) {
            this.barreReaction += STEP_REACTION + dextérité;
            if (this.barreReaction >= MAX_REACTION) {
                this.barreReaction -= MAX_REACTION;
                reaction = true;
            }
        }

        return reaction;
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

    public void pop() {};
}