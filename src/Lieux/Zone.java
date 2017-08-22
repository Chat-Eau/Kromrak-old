package Lieux;

import Evenements.Salle;
import Outils.Coord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lamg030499 on 2017-05-01.
 */
public class Zone {
    public Salle entree;
    public String type = "Non initialisé";
    public int niveau = 1;
    private List<Salle> salles = new ArrayList<>();

    public Zone(Salle entree, String type, int niveau){
        this.entree = entree;
        this.type = type;
        this.niveau = niveau;
    }
    public Zone(){
        this.salles.add(new Salle(new Coord(0,0)));
        this.entree = getSalle(new Coord(0,0));
        this.type = type;
    }

    public Salle getSalle(Coord coord) {
        for(Salle salle : this.salles){
            if (salle.getCoord() == coord)
                return salle;
        }
        return null;
    }
}
