package Objets;

/**
 * Created by lamg030499 on 2017-04-28.
 */
public class Equipement extends Objet {
    private boolean equipé = false;

    public Equipement () {
        this.nom = "Epée courte et molle";
        this.valeur = 3;
        this.equipé = true;
    }

    protected Equipement (String nom, int valeur, boolean equipé) {
        super(nom, valeur);
        this.equipé = equipé;
    }

    public String toString(){
        return super.toString();
    }

    public void setEquipé(boolean equipé) {
        this.equipé = equipé;
    }
    public boolean getEquipé() {return equipé; }
}
