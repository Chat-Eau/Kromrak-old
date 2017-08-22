package Personnages;


import Objets.Arme;
import Conteneur.Conteneur;
import Outils.Outils;

import static Outils.Constantes.*;

/**
 * Created by lapb290796 on 2017-02-21.
 */
public abstract class Personnage {
    protected Arme arme;
    protected String nom;
    protected int lvl;
    protected Conteneur inventaire = new Conteneur("Les pochettes de Kromrak");

    //TODO: La cible devrait etre le paramètre d'une fonction attaquer, pas une variable, non?
    /*
    BL: Ouais, mais pour la gestion des enemis, un attribut est plus simple parce que la cible par défaut des ennemis
    est (presque) toujours Kromrak. Pour Kromrak, on va avoir besoin d'une variable locale dans
    cible de toute façon.
    */
    protected Personnage cible;

    protected boolean reaction = false;

    private int barreVitesse = 0;
    private int barreReaction = 0;

    //Attributs
    //TODO: Une classe pour chaque attribut pour séparer les get/set, les gérer individuellement pour les caps...
    protected int vieMax;
    protected int vie;
    protected int vitesse = 0;
    protected int force = 0;
    protected int dextérité = 0;//à faire
    protected int endurance = 0;//à faire
    protected int intelligence = 0;//à faire
    protected int CA = 1;



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

        cible.recevoirDegats(Outils.minCap((degats + force), 1));

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
                getObjets().toString();
    }

    public void resetBarreVitesse(){
        this.barreVitesse = 0;
    }
    public void resetBarreReaction(){
        this.barreReaction = 0;
    }
    public void resetBarres(){
        resetBarreVitesse();
        resetBarreReaction();
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

    public void setDextérité(int dextérité) {
        this.dextérité = dextérité;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void setCA(int CA) {
        this.CA = CA;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public void setVieMax(int vieMax) {
        this.vieMax = vieMax;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public Conteneur getObjets() {
        return inventaire;
    }

    public int getLvl() { return lvl; }

    public void activerParade() { reaction = true; }

    public void setCible(Personnage cible) {this.cible = cible; }

    public void setNom(String nom) {this.nom = nom; }

    public void pop() {};
}