package Evenements;

import Personnages.Kromrak;

import java.util.ArrayList;
import java.util.List;

import static Outils.Constantes.SEP;

/**
 * Created by lamg030499 on 2017-05-04.
 */
public class Evenement {
    protected String description = "";
    protected String nom = "Coffre";
    List<Evenement> evenements = new ArrayList<>();
    boolean auto = false;

    public Evenement(List<Evenement> evenements, String descEntree, boolean auto){
        this.evenements = evenements;
        this.description = descEntree;
    }

    public Evenement(List<Evenement> evenements, String descEntree){
        this.evenements = evenements;
        this.description = descEntree;
    }

    public Evenement(){
    }

    public void activer() {
        System.out.println(this + SEP);
        for(int i = 0; i < evenements.size(); i++) {
            if (evenements.get(i).getAuto()) evenements.get(i).activer();
            else {
                System.out.println((i+1) + evenements.get(i).getNom());
            }
        }


    }

    public String getNom() {
        return nom;
    }

    public String toString(){
        return description;
    }

    public void retour() {
        Kromrak.getInstance().getSalle().activer();
    }

    protected boolean getAuto() {return auto;}
}
