package Lieux;

import Evenements.Combat;
import Evenements.Evenement;

import static Outils.Constantes.SEP;

/**
 * Created by lamg030499 on 2017-05-01.
 */
public class Salle {
    String nom;
    String descEntree;

    Evenement evenement = new Evenement();

    public Salle(Evenement evenement, String nom, String descEntree){
        this.evenement = evenement;
        this.nom = nom;
        this.descEntree = descEntree;
    }

    public Salle(){
        this.evenement = Combat.getInstance().newCombat();
        this.nom = "Salle de base";
        this.descEntree = "Vous entrez dans une salle à la fois lumineuse et ténébreuse."
        + SEP + "Plus rien n'a de sens.";
    }

    public String displayEntree(){
        return descEntree;
    }
    public String toString(){
        return nom;
    }
}
