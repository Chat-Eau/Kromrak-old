package Objets;

/**
 * Created by lamg030499 on 2017-04-27.
 */
public class Objet {
    public String nom;
    public int valeur;

    public boolean getEquipé() {return false; }


    public Objet(){
        nom = "Pièce d'or";
        valeur = 1;
    }
    public Objet(String nom, int valeur){
        this.nom = nom;
        this.valeur = valeur;
    }
    public Objet(int valeur){
        this.nom = valeur > 1 ? "Pièces d'or" : "Pièce d'or";
        this.valeur = valeur;
    }
    public Objet(String nom){
        this.nom = nom;
        this.valeur = 1;
    }

    public String getNom(){
        return this.nom;
    }
    public int getValeur(){
        return this.valeur;
    }

    //TODO:GLM: Marche pas, mais je crois qu'il faut une fonction comme ça pour equiper les armes/armures efficacement
//    public Objet getByClass(List Objet, Class classe) {
//        for (int i = 0; i < Objet.size(); i++){
//            if (Objet.get(i).getClass().equals(classe)){
//                return (Objet) Objet.get(i);
//            }
//        }
//        return null;
//    }
    public String toString(){
        if (nom == "Pièces d'or" || nom == "Pièce d'or") {
            return (valeur + " " + nom);
        }
        else {
            return nom + ", valeur de " + valeur + " pièces.";
        }
    }
}
