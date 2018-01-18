package Objets;

public class Equipement extends Objet {
    //TODO:Refaire en ur
    private boolean equiped = false;
    private String type;

    public Equipement () {
        this.nom = "Helmet of the healer";
        this.valeur = 666;
        this.equiped = false;
        this.type = "head";
    }

    protected Equipement (String nom, int valeur, String type) {
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

    public String getType() {
        return type;
    }
}
