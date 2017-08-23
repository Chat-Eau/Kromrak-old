package Evenements;

import Evenements.Combat;
import Evenements.Evenement;
import Outils.Coord;
import Personnages.Kromrak;

import java.awt.*;
import java.util.List;

import static Outils.Constantes.SEP;

/**
 * Created by lamg030499 on 2017-05-01.
 */
public class Salle extends Evenement implements Runnable{
    Coord coord;

    public Salle(List<Evenement> evenements, String descEntree, Coord coord){
        this.evenements = evenements;
        this.description = descEntree;
        this.coord = coord;
    }

    public Salle(){
        this.evenements.add(new Combat());
        this.description = "Vous entrez dans une salle non initialisée.";
        this.coord.x = -1;
        this.coord.y = -1;
    }

    public Salle(Coord coord){
        this.evenements.add(new Combat());
        this.description = "Vous entrez dans une salle non initialisée aux coordonnées.";
        this.coord = coord;
    }

    public Coord getCoord() { return this.coord; }
    public void setDescription(String description){
        this.description = description;
    }
    public void addEvenement(Evenement evenement){
        this.evenements.add(evenement);
    }

    @Override
    public void activer() {
        Kromrak.getInstance().setSalle(this);
        super.activer();
    }

    //C'est le truc qui se lance quand on démarre un thread.
    //Salle n'aurra probablemnt pas de thread dédié, c'était juste pour tester.
    @Override
    public void run() {
        activer();
    }
}