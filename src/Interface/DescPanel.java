package Interface;

import Interface.Objets.JKromrakExitButton;
import Interface.Objets.JKromrakHideButton;
import Personnages.Kromrak;
import Threads.KeepBarsUpdated;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by lamg030499 on 2017-09-06.
 */
public class DescPanel extends JPanel {
    public JProgressBar barreVie;
    public JProgressBar barreReac;
    public JProgressBar barreVit;
    public JKromrakExitButton btnExit;
    public JKromrakHideButton btnHide;


    static public int width;
    static public int height;

    public ImageIcon createImageIcon(String path, String description){
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null){
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public DescPanel(){
            width = KFrame.getInstance().getWidth();
            height = KFrame.getInstance().getHeight()/5 - 30;

        //width= 200;
        //height = 100;
        this.setLocation(0,0);
        this.setSize(width,height);
        this.setLayout(null);
        this.setVisible(true);
        this.setBackground(Color.gray);

        //ImageIcon icon = createImageIcon("/Images/exitButton.png", "Exit button");
        btnExit = new JKromrakExitButton();
        btnExit.setLocation(width - width / 40 - 15,15);
        btnExit.setSize(width/40, width/50);
        btnExit.setVisible(true);
        this.add(btnExit);

        btnHide = new JKromrakHideButton();
        btnHide.setLocation(width - width / 20 - 30,15);
        btnHide.setSize(width/40, width/50);
        btnHide.setVisible(true);
        this.add(btnHide);

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

        barreVie = new JProgressBar();
        this.add(barreVie);
        barreVie.setLocation(10,10);
        barreVie.setSize(width/10, height/15);
        barreVie.setForeground(Color.green);

        barreReac = new JProgressBar();
        this.add(barreReac);
        barreReac.setLocation(10,25);
        barreReac.setSize(width/10, height/15);
        barreReac.setForeground(Color.orange);
        barreReac.setVisible(true);

        barreVit = new JProgressBar();
        this.add(barreVit);
        barreVit.setLocation(10,40);
        barreVit.setSize(width/10, height/15);
        barreVit.setForeground(Color.yellow);
        barreVit.setVisible(true);




        this.setVisible(true);
        KeepBarsUpdated keepBarsUpdated = new KeepBarsUpdated(barreVie, barreVit, barreReac);
        keepBarsUpdated.start();
    }
}
