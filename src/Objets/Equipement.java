package Objets;

public class Equipement extends Objet {
    //TODO:Refaire en ur
    private boolean equipé = false;
    private String type;

    public Equipement () {
        this.nom = "Helmet of the healer";
        this.valeur = 666;
        this.equipé = false;
        this.type = "head";
    }

    protected Equipement (String nom, int valeur, type) {
        super(nom, valeur);
    }

    public String toString(){
        return super.toString();
    }

    public void setEquipé(boolean equipé) {
        this.equipé = equipé;
    }
    public boolean getEquipé() {return equipé; }
}
