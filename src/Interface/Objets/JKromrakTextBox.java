package Interface.Objets;

import Interface.KFrame;
import Threads.ScrollDown;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;

import static Outils.Constantes.SEP;
import static java.lang.Thread.sleep;

public class JKromrakTextBox extends JEditorPane{

    public JKromrakTextBox(){
        super();
    }

    public void addTextln(String string){
        try {
            this.getDocument().insertString(this.getDocument().getLength(),string + SEP, null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        ScrollDown scrollDown = new ScrollDown(this);
        scrollDown.start();
    }

    public void addText(String string){
        try {
            this.getDocument().insertString(this.getDocument().getLength(),string, null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        ScrollDown scrollDown = new ScrollDown(this);
        scrollDown.start();    }
}
