package Lieux;

import Evenements.Salle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lamg030499 on 2017-05-01.
 */
public class Zone {
    public Salle salles[][] = new Salle [10][10];
    public String type = "Non initialisé";

    public Zone(){
        for (int x = 0; x < 10; x++){
            for (int y = 0; y < 10; y++){
                this.salles[x][y] = new Salle();
                this.salles[x][y].setDescription("Salle x = " + x + ", y = " + y + " .");
            }
        }
    }
}
