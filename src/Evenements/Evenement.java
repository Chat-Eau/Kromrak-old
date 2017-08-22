package Evenements;

import Personnages.Kromrak;

import java.util.ArrayList;
import java.util.List;

import static Outils.Constantes.SEP;

/**
 * Created by lamg030499 on 2017-05-04.
 */
public class Evenement {
    String description = "";
    List<Evenement> evenements = new ArrayList<>();
    boolean auto = false;
    //TODO:GLM: On devrais mettre un bool dans Evenement pour identifier les evenements agro/automatique.
    //Done!

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
        for(Evenement evenement: evenements) {
            if (getAuto()) evenement.activer();
        }
    }

    public String toString(){
        return description;
    }

    public void retour() {
        Kromrak.getInstance().getSalle().activer();
    }

    protected boolean getAuto() {return auto;}
}
