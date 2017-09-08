package Threads;

import Personnages.Kromrak;

import javax.swing.*;

import static Outils.Constantes.MAX_REACTION;
import static Outils.Constantes.MAX_VITESSE;

public class KeepBarsUpdated extends Thread{
    JProgressBar vie, vit, reac;
    public KeepBarsUpdated(JProgressBar vie, JProgressBar vit, JProgressBar reac){
        this.vie = vie;
        this.vit = vit;
        this.reac = reac;
    }

    public void run(){
                while (true){//TODO: Placer une condition de fin du jeu
            try {
                Thread.sleep(50);
            } catch (InterruptedException ignore){}
            vie.setValue(Kromrak.getInstance().getVie());
            vie.setMaximum(Kromrak.getInstance().getVieMax());
            if (Kromrak.getInstance().isReaction()){
                reac.setValue(MAX_REACTION);
            } else {
                reac.setValue(Kromrak.getInstance().getBarreReaction());
            }
            reac.setMaximum(MAX_REACTION);
            vit.setValue(Kromrak.getInstance().getBarreVitesse());
            vit.setMaximum(MAX_VITESSE);
        }
    }
}
