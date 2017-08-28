package Threads;

import Personnages.Kromrak;
import Threads.KromrakForm.*;
import javafx.scene.control.ProgressBar;

import javax.swing.*;

import static javafx.scene.input.KeyCode.K;

/**
 * Created by lamg030499 on 2017-08-28.
 */
public class KeepBarsUpdated extends Thread{
    JProgressBar vie, vit;
    KeepBarsUpdated(JProgressBar vie, JProgressBar vit){
        this.vie = vie;
        this.vit = vit;
    }

    public void run(){
            //TODO:Créer un listener
                while (true){//TODO: Placer une condition de fin du jeu
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignore){}
            vie.setValue(Kromrak.getInstance().getVie());
            vie.setMaximum(Kromrak.getInstance().getVieMax());
            vit.setValue(Kromrak.getInstance().getBarreReaction());
        }
    }
}
