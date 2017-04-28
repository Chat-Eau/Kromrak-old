package Objets;

/**
 * Created by lamg030499 on 2017-04-28.
 */
public class Equipement extends Objet {
    public Equipement () {
        this.nom = "Epée courte et molle";
        this.valeur = 3;
    }

    protected Equipement (String nom, int valeur) {
        super(nom, valeur);
    }

    public String toString(){
        return super.toString();
    }
}
