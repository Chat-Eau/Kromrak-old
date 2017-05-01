package Objets;

/**
 * Created by lamg030499 on 2017-04-28.
 */
public class Armure extends Equipement{
    public Armure () {
        this.nom = "La Justice Juteuse";
        this.valeur = 3;
    }

    public Armure (String nom, int valeur, boolean equipé) {
        super(nom, valeur, equipé);
    }

    public String toString(){
        return super.toString();
    }
}
