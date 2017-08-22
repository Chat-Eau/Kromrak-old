package Lieux;

import Evenements.Salle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lamg030499 on 2017-05-01.
 */
public class Zone {
    public Salle entree;
    public String type = "Non initialisé";
    public int niveau = 1;

    public Zone(Salle entree, String type, int niveau){
        this.entree = entree;
        this.type = type;
        this.niveau = niveau;
    }
}
