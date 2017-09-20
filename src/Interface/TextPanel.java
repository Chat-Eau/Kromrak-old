package Interface;

import Interface.Objets.JKromrakTextBox;
import Personnages.Kromrak;
import Threads.KeepBarsUpdated;

import javax.swing.*;
import java.awt.*;

import static Outils.Constantes.SEP;

/**
 * Created by lamg030499 on 2017-09-06.
 */
public class TextPanel extends JPanel {
    public JKromrakTextBox zoneTexte = new JKromrakTextBox();


    public TextPanel(){
        this.setLocation(0,400);
        this.setSize(800,375);
        this.setLayout(null);
        this.setVisible(true);
        this.setBackground(Color.LIGHT_GRAY);

        JScrollPane scrollPane = new JScrollPane(zoneTexte);
        scrollPane.setBackground(Color.GREEN);
        scrollPane.setLocation(0, 0);
        scrollPane.setSize(800,375);
        scrollPane.setVisible(true);
        scrollPane.setHorizontalScrollBar(null);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrollPane);

        zoneTexte.setLocation(0,0);
        zoneTexte.setSize(200,100);
    }
}
