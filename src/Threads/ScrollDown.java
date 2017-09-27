package Threads;

import Interface.Objets.JKromrakTextBox;
import Personnages.Kromrak;

import javax.swing.*;
import javax.swing.text.BadLocationException;

import static Outils.Constantes.MAX_REACTION;
import static Outils.Constantes.MAX_VITESSE;

public class ScrollDown extends Thread{
    JKromrakTextBox textBox;
    public ScrollDown(JKromrakTextBox textBox){
        this.textBox = textBox;
    }

    public void run(){
        try {
            sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        textBox.setCaretPosition(textBox.getDocument().getLength());
        this.interrupt();
    }
}
