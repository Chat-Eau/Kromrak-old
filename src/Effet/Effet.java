package Effet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMG030499 on 2017-08-21.
 */
public class Effet {
    String nom = "";
    String description = "";
    int puissance;
    int duree;
    boolean visible = true;

    public Effet(String nom, String description, int puissance, int duree, boolean visible){
        this.nom = nom;
        this.description = description;
        this.puissance = puissance;
        this.duree = duree;
        this.visible = visible;
    }

    public int reduire(){
        return --duree;
    }

    //GLM:Pas sur que ça soit pertinent.. Mais ca devrais marcher :/
    public void mergeAll(List<Effet> effets){
        for (int i = 0; i < effets.size(); i++) {
            for (int j = i + 1; j < effets.size(); j++) {
                if(effets.get(i).nom == effets.get(j).nom && effets.get(i).puissance == effets.get(j).puissance){
                    Effet tempEffet = effets.get(i);
                    effets.add(new Effet(tempEffet.nom, tempEffet.description, tempEffet.puissance, tempEffet.duree + effets.get(j).duree, tempEffet.visible));
                    effets.remove(j);
                    effets.remove(i);
                }
            }
        }
    }
}
