package Evenements;

import Evenements.Combat;
import Evenements.Evenement;

import java.util.List;

import static Outils.Constantes.SEP;

/**
 * Created by lamg030499 on 2017-05-01.
 */
public class Salle extends Evenement{
    public Salle(List<Evenement> evenements, String descEntree){
        this.evenements = evenements;
        this.description = descEntree;
    }

    public Salle(){
        this.evenements.add(Combat.newCombat());
        this.description = "Vous entrez dans une salle non initialisée.";
    }
}