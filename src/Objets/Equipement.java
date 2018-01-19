package Objets;

public class Equipement extends Objet {
    //TODO:Refaire en ur
    private boolean equiped;
    private String type;

    public Equipement () {
        this.nom = "Helmet of the healer";
        this.valeur = 666;
        this.equiped = false;
        this.type = "head";
    }

    protected Equipement (String nom, int valeur, String type) {
        super(nom, valeur);
        this.equiped = false;
        this.type = type;
    }

    public String toString(){
        return super.toString();
    }

    public void setEquiped(boolean equiped) {
        this.equiped = equiped;
    }

    public boolean isEquiped() {return equiped;}

    public String getType() {
        return type;
    }
}
