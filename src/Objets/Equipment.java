package Objets;

public class Equipment extends Objet {
    //TODO:Refaire en ur
    private boolean equiped;
    private String type;

    public Equipment(String nom, int valeur, String type) {
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
