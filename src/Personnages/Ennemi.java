package Personnages;

import Objets.Arme;
import Objets.Objet;
import Outils.Outils;

import java.util.Random;

/**
 * Created by lapb290796 on 2017-02-21.
 */
public class Ennemi extends Personnage {


    public Ennemi(String nom) {
        this.nom = nom;
        objets.add(new Arme());
        this.arme = (Arme) objets.get(0);
        //TODO: Pas besoin de cible, il faut seulement separer les IA.
        //TODO: Faire deux fonctions jouerTour(). Celle des ennemis attaque toujours le joueur.
        this.cible = Kromrak.getInstance();

        vieMax = 5;
        vie = vieMax;
        vitesse = Outils.lancerDes(1, 0);
        force = 2;
        dextérité = 2;
        endurance = 0;
        intelligence = 0;
        CA = 0;

        for (int i = new Random().nextInt(5) + 10; 0 < i; i--) {
            objets.add(new Objet());
        }
    }
}
