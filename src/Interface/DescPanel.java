package Interface;

import Personnages.Kromrak;
import Threads.KeepBarsUpdated;

import javax.swing.*;
import java.awt.*;

import static Outils.Constantes.SEP;

/**
 * Created by lamg030499 on 2017-09-06.
 */
public class DescPanel extends JPanel {
    public JProgressBar barreVie = new JProgressBar();
    public JProgressBar barreReac = new JProgressBar();
    public JProgressBar barreVit = new JProgressBar();
    public JEditorPane zoneTexte = new JEditorPane();


    public DescPanel(){
        this.setLocation(0,0);
        this.setSize(800,200);
        this.setLayout(null);
        this.setVisible(true);
        this.setBackground(Color.LIGHT_GRAY);


        JScrollPane scrollPane = new JScrollPane(zoneTexte);
        scrollPane.setBackground(Color.GREEN);
        scrollPane.setLocation(50, 50);
        scrollPane.setSize(200,100);
        scrollPane.setVisible(true);
        scrollPane.setHorizontalScrollBar(null);
        this.add(scrollPane);

        JLabel label = new JLabel();
        label.setSize(30, 10);
        label.setLocation(400, 10);
        label.setText("VIT " + Kromrak.getInstance().getVitesse());
        this.add(label);

        zoneTexte.setLocation(0,0);
        zoneTexte.setSize(200,100);
        zoneTexte.setText("Ligne 1");
        zoneTexte.setText(zoneTexte.getText() + SEP + "Ligne après Separateur");

        barreReac.setLocation(10,25);
        barreReac.setSize(100,10);
        barreReac.setForeground(Color.orange);
        this.add(barreReac);

        barreVie.setLocation(10,10);
        barreVie.setSize(100,10);
        barreVie.setForeground(Color.green);
        this.add(barreVie);

        barreVit.setLocation(10,40);
        barreVit.setSize(100,10);
        barreVit.setForeground(Color.yellow);
        this.add(barreVit);

        KeepBarsUpdated keepBarsUpdated = new KeepBarsUpdated(barreVie, barreVit, barreReac);
        keepBarsUpdated.start();
    }
}
