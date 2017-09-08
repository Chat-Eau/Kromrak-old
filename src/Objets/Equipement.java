package Objets;

public class Equipement extends Objet {
    //TODO:Refaire en ur
    private boolean equipé = false;

    public Equipement () {
        this.nom = "Epée courte et molle";
        this.valeur = 3;
        this.equipé = true;
    }

    protected Equipement (String nom, int valeur) {
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
