package Threads;

import Personnages.Kromrak;

import javax.swing.*;
import java.awt.*;

public class KromrakForm {
    public JPanel panel1;

    public JProgressBar getBarreVie() {
        return barreVie;
    }

    public JProgressBar barreVie;
    public JProgressBar barreReac;
    private JProgressBar barreVit;
    private JTextArea textMain;

    public static void main(String[] args){
        KromrakForm kromrakForm = new KromrakForm();
        kromrakForm.prepareGUI();
    }

    private void prepareGUI(){
        JFrame frame = new JFrame();
        frame.getContentPane().add(panel1);

        barreVie.setMaximum(Kromrak.getInstance().getVieMax());

        //Taille
        frame.setSize(new Dimension(800, 600));
        //Position d'apparition
        frame.setLocationRelativeTo(null);
        //Action de fermeture
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Titre
        frame.setTitle("KROMRAK LE KROMRAK:L'APPLICATION");
        //Empecher le resize
        //frame.setResizable(false);
        //Affiche
        frame.setVisible(true);

        KeepBarsUpdated keepBarsUpdated = new KeepBarsUpdated(barreVie, barreVit, barreReac);
        keepBarsUpdated.start();
        RunMain runMain = new RunMain(panel1);
        runMain.start();
    }
}
