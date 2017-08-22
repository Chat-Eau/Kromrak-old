package Evenements;

import Evenements.Combat;
import Evenements.Evenement;
import Outils.Coord;

import java.awt.*;
import java.util.List;

import static Outils.Constantes.SEP;

/**
 * Created by lamg030499 on 2017-05-01.
 */
public class Salle extends Evenement{
    Coord coord;

    public Salle(List<Evenement> evenements, String descEntree, Coord coord){
        this.evenements = evenements;
        this.description = descEntree;
        this.coord = coord;
    }

    public Salle(){
        this.evenements.add(Combat.newCombat());
        this.description = "Vous entrez dans une salle non initialisée.";
        this.coord.x = -1;
        this.coord.y = -1;
    }

    public Salle(Coord coord){
        this.evenements.add(Combat.newCombat());
        this.description = "Vous entrez dans une salle non initialisée.";
        this.coord = coord;
    }

    public Coord getCoord() { return this.coord; }
    public void setDescription(String description){
        this.description = description;
    }
    public void addEvenement(Evenement evenement){
        this.evenements.add(evenement);
    }
}