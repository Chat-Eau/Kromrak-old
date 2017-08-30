package Lieux;

import Evenements.Salle;
import Outils.Coord;

import java.util.ArrayList;
import java.util.List;

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
        this.salles.add(new Salle(new Coord(1,0)));
        this.salles.add(new Salle(new Coord(-1,0)));
        this.salles.add(new Salle(new Coord(0,-1)));
        this.salles.add(new Salle(new Coord(0,1)));
        this.entree = getSalle(new Coord(0,0));
        this.type = type;
    }

    public Salle getSalle(Coord coord) {
        for(Salle salle : this.salles){
            if (salle.getCoord().compareTo(coord))
                return salle;
        }
        return null;
    }
}
