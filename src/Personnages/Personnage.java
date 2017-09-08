package Personnages;

import Evenements.Combat;
import Objets.Arme;
import Conteneur.*;
import Objets.Objet;
import Outils.Outils;

import java.awt.*;
import java.util.Random;

import static Outils.Constantes.*;
import javax.swing.*;

public abstract class Personnage{
    protected Arme arme;
    protected String nom;
    protected int lvl;
    protected Inventaire inventaire = new Inventaire("Les pochettes de Kromrak");

    /*BL: Ouais, mais pour la gestion des enemis, un attribut est plus simple parce que la cible par défaut des ennemis
    est (presque) toujours Kromrak. Pour Kromrak, on va avoir besoin d'une variable locale dans
    cible de toute façon.*/

    protected Personnage cible;

    public boolean isReaction() {
        return reaction;
    }

    protected boolean reaction = false;

    public int getBarreVitesse() {
        return barreVitesse;
    }

    private int barreVitesse = 0;

    public int getBarreReaction() {
        return barreReaction;
    }

    private int barreReaction = 0;

    //Attributs
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
        degats += force;

        cible.recevoirDegats(Outils.minCap((degats), 1));

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
    public abstract void jouerTour(Combat combat);

    public String toString () {
        String resultat = "Nom: " + nom + SEP +
                "Vie: " + this.vie + "/" + this.vieMax + SEP +
                "Vitesse: " + vitesse + SEP +
                "Force: " + force + SEP +
                "Dextérité: " + dextérité + SEP +
                "Endurance: " + endurance + SEP +
                "Intelligence: " + intelligence + SEP +
                "Classe d'armure: " + CA + SEP + SEP +
                "Inventaire: " + SEP;
        if (this.arme != null)
            resultat += "Arme: " + this.arme.toString() + SEP;
        return resultat + getObjets().toString();
    }

    protected void resetBarreVitesse(){
        this.barreVitesse = 0;
    }
    protected void resetBarreReaction(){
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

    public void pop() {}

    public Conteneur getInventaire() {
        return inventaire;
    }
}