package Personnages;

import Evenements.Combat;
import Objets.Arme;
import Objets.Objet;
import Outils.Outils;

import java.util.Random;

import static Outils.Constantes.SEP;

/**
 * Created by lapb290796 on 2017-02-21.
 */
public class Ennemi extends Personnage {


    public Ennemi(String nom) {
        this.nom = nom;
        //TODO: On a tu vraiment besoin de cible?
        this.cible = Kromrak.getInstance();

        reaction = false;
        vieMax = 5;
        vie = vieMax;
        //TODO:GLM: Donner un stat de dommage sans arme d4? Sinon, tout les ennemis sans armes vont toujours frapper pareil.
        //TODO:GLM: Une alternative serait de faire que la force a 75% de chance de boost les dommages de 1 par point de force? Quelque chose dans le genre.
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

    public void jouerTour(){
        System.out.println("Au tour de : " + getNom());
        attaquer();
    }

    protected void reactionEnnemi() {
        if (new Random().nextInt(3) == 0) {
            System.out.print(getNom() + " bloque l'attaque et ");
            activerParade();
        } else {
            System.out.println(getNom() + " contre-attaque!" + SEP);
            attaquer();
        }
    }

    public void pop() {
        System.out.println(this.nom + " est mort.");

        while (0 < this.objets.size()) {
            if (new Random().nextInt(10) == 0) {
                Combat.getInstance().lootAdd((Objet) this.objets.get(0));
            }
            this.objets.remove(0);
        }
        Combat.getInstance().personnagesRemove(this);
    }
}
