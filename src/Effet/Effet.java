package Effet;

<<<<<<< HEAD
import Personnages.Personnage;
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> 27fe75a8f9a22f0044918560c10f881747332c71

/**
 * Created by LAMG030499 on 2017-08-21.
 */
public class Effet {
<<<<<<< HEAD
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
=======
    String nom = "";
    String description = "";
    int puissance;
    int duree;
    boolean visible = true;

    public Effet(String nom, String description, int puissance, int duree, boolean visible){
        this.nom = nom;
        this.description = description;
        this.puissance = puissance;
        this.duree = duree;
        this.visible = visible;
    }

    public int reduire(){
        return --duree;
    }

    //GLM:Pas sur que ça soit pertinent.. Mais ca devrais marcher :/
    public void mergeAll(List<Effet> effets){
        for (int i = 0; i < effets.size(); i++) {
            for (int j = i + 1; j < effets.size(); j++) {
                if(effets.get(i).nom == effets.get(j).nom && effets.get(i).puissance == effets.get(j).puissance){
                    Effet tempEffet = effets.get(i);
                    effets.add(new Effet(tempEffet.nom, tempEffet.description, tempEffet.puissance, tempEffet.duree + effets.get(j).duree, tempEffet.visible));
                    effets.remove(j);
                    effets.remove(i);
                }
            }
        }
>>>>>>> 27fe75a8f9a22f0044918560c10f881747332c71
    }
}
