package Interface;

import Personnages.Kromrak;
import Threads.KeepBarsUpdated;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lamg030499 on 2017-09-06.
 */
public class BtnPannel extends JPanel {
    public JProgressBar barreVie = new JProgressBar();
    public JProgressBar barreReac = new JProgressBar();
    public JProgressBar barreVit = new JProgressBar();
    JLabel label = new JLabel();


    public BtnPannel(){
        this.setLocation(0,0);
        this.setSize(800,200);
        this.setLayout(null);
        this.setVisible(true);
        this.setBackground(Color.LIGHT_GRAY);

        JLabel labelVit = new JLabel();
        labelVit.setSize(100, 10);
        labelVit.setLocation(400, 10);
        labelVit.setText("VIT : " + Kromrak.getInstance().getVitesse());
        this.add(labelVit);

        JLabel labelInt = new JLabel();
        labelInt.setSize(100, 10);
        labelInt.setLocation(400, 30);
        labelInt.setText("INT : " + Kromrak.getInstance().getIntelligence());
        this.add(labelInt);

        JLabel labelCA = new JLabel();
        labelCA.setSize(100, 10);
        labelCA.setLocation(400, 50);
        labelCA.setText("CA  : " + Kromrak.getInstance().getCA());
        this.add(labelCA);

        JLabel labelFor = new JLabel();
        labelFor.setSize(100, 10);
        labelFor.setLocation(500, 10);
        labelFor.setText("FOR : " + Kromrak.getInstance().getForce());
        this.add(labelFor);

        JLabel labelDex = new JLabel();
        labelDex.setSize(100, 10);
        labelDex.setLocation(500, 30);
        labelDex.setText("DEX : " + Kromrak.getInstance().getDextérité());
        this.add(labelDex);

        JLabel labelEnd = new JLabel();
        labelEnd.setSize(100, 10);
        labelEnd.setLocation(500, 50);
        labelEnd.setText("END : " + Kromrak.getInstance().getEndurance());
        this.add(labelEnd);

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
