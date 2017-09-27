package Interface;

import Interface.Objets.JKromrakTextBox;
import Personnages.Kromrak;
import Threads.KeepBarsUpdated;
import com.sun.org.apache.xpath.internal.functions.FuncFloor;

import javax.swing.*;
import java.awt.*;

import static Outils.Constantes.SEP;

/**
 * Created by lamg030499 on 2017-09-06.
 */
public class TextPanel extends JPanel {
    public JKromrakTextBox zoneTexte = new JKromrakTextBox();

    static public int width;
    static public int height;


    public TextPanel(){
        //Les - de width et height sont la au cas ou la fenetre n'est pas en borderless fullscreen.
        width = KFrame.getInstance().getWidth()/* - 5*/;
        height = KFrame.getInstance().getHeight()/3/* - 30*/;
        this.setLocation(0, (int) Math.round(KFrame.getInstance().getHeight()*0.66666666));
        this.setSize(width,height);
        this.setLayout(null);
        this.setVisible(true);
        this.setBackground(Color.LIGHT_GRAY);

        JScrollPane scrollPane = new JScrollPane(zoneTexte);
        scrollPane.setBackground(Color.GREEN);
        scrollPane.setLocation(0, 0);
        scrollPane.setSize(width,height);
        scrollPane.setVisible(true);
        scrollPane.setHorizontalScrollBar(null);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrollPane);

        zoneTexte.setLocation(0,0);
        zoneTexte.setSize(200,100);

        this.zoneTexte.setFont(new Font("Palatino Linotype", 0, width/150 + 8));
    }
}
