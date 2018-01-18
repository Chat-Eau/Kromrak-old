package Objets;

public class Equipement extends Objet {
    //TODO:Refaire en ur
    private boolean equiped = false;

    public Equipement () {
        this.nom = "Epée courte et molle";
        this.valeur = 3;
        this.equiped = true;
    }

    protected Equipement (String nom, int valeur) {
        super(nom, valeur);
    }

    public String toString(){
        return super.toString();
    }

    public void setEquiped(boolean equiped) {
        this.equiped = equiped;
    }
    public boolean getEquiped() {return equiped; }

    public boolean isEquiped() {return true;}
}
