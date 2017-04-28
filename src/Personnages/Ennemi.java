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
        //TODO: Pas besoin de cible, il faut seulement separer les IA.
        //TODO: Faire deux fonctions jouerTour(). Celle des ennemis attaque toujours le joueur.
        this.cible = Kromrak.getInstance();

        reaction = false;
        vieMax = 5;
        vie = vieMax;
        force = 2;
        intelligence = 1;
        dextérité = 3;
        vitesse = Outils.lancerDes(1);
        endurance = 0;
        CA = 0;

        if (new Random().nextInt(3) == 0) {
            objets.add(new Arme());
            this.arme = (Arme) objets.get(0);
        }
        for (int i = new Random().nextInt(5) + 10; 0 < i; i--) {
            objets.add(new Objet());
        }
    }

    public void recevoirDegats (int nbDegats)
    {
        super.recevoirDegats(nbDegats);
        if (reaction){
        //TODO:GLM: Réagir
            reaction = false;
        }
    }
}
