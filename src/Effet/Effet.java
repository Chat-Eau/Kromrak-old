package Effet;

import Personnages.Personnage;

/**
 * Created by LAMG030499 on 2017-08-21.
 */
public class Effet {
    protected Personnage personnage;
    protected String trigger;
    protected String description;
    protected int duree;

    //[0] = Bonus
    //[1] = durée
    protected int vieMax[];
    protected int vie[];
    protected int vitesse[];
    protected int force[];
    protected int dextérité[];
    protected int endurance[];
    protected int intelligence[];
    protected int CA[];

    protected int vieMaxCible[];
    protected int vieCible[];
    protected int vitesseCible[];
    protected int forceCible[];
    protected int dextéritéCible[];
    protected int enduranceCible[];
    protected int intelligenceCible[];
    protected int CACible[];

    public boolean activer(){
        if (vie != null) personnage.setVie(personnage.getVie() + vieMax[0]);
        if (vie != null) personnage.setVie(personnage.getVie() + vie[0]);
        if (vie != null) personnage.setVie(personnage.getVie() + vitesse[0]);
        if (vie != null) personnage.setVie(personnage.getVie() + force[0]);
        if (vie != null) personnage.setVie(personnage.getVie() + dextérité[0]);
        if (vie != null) personnage.setVie(personnage.getVie() + endurance[0]);
        if (vie != null) personnage.setVie(personnage.getVie() + intelligence[0]);
        if (vie != null) personnage.setVie(personnage.getVie() + CA[0]);

        if (vie != null) personnage.getCible().setVie(personnage.getCible().getVie() + vieMax[0]);
        if (vie != null) personnage.getCible().setVie(personnage.getCible().getVie() + vie[0]);
        if (vie != null) personnage.getCible().setVie(personnage.getCible().getVie() + vitesse[0]);
        if (vie != null) personnage.getCible().setVie(personnage.getCible().getVie() + force[0]);
        if (vie != null) personnage.getCible().setVie(personnage.getCible().getVie() + dextérité[0]);
        if (vie != null) personnage.getCible().setVie(personnage.getCible().getVie() + endurance[0]);
        if (vie != null) personnage.getCible().setVie(personnage.getCible().getVie() + intelligence[0]);
        if (vie != null) personnage.getCible().setVie(personnage.getCible().getVie() + CA[0]);

        return duree > 0;
    }

    public String getTrigger() {
        return trigger;
    }

    @Override
    public String toString() {
        return description;
    }
}
