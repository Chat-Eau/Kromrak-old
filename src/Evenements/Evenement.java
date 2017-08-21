package Evenements;

import java.util.ArrayList;
import java.util.List;

import static Outils.Constantes.SEP;

/**
 * Created by lamg030499 on 2017-05-04.
 */
public class Evenement {
    String description = "";
    List<Evenement> evenements = new ArrayList<>();

    public Evenement(List<Evenement> evenements, String descEntree){
        this.evenements = evenements;
        this.description = descEntree;
    }

    public Evenement(){
    }

    public void activer() {
        System.out.println(this + SEP);
        for(Evenement evenement: evenements) {
            evenement.activer();
        }
    }

    public String toString(){
        return description;
    }
}
