package Threads;

import Evenements.Salle;
import Lieux.Zone;
import Outils.Coord;
import Personnages.Kromrak;
import javafx.scene.control.ProgressBar;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class KromrakForm {
    public JPanel panel1;
    public JProgressBar barreVie;
    public JProgressBar barreVit;
    public JTextField textField1;

    public static void main(String[] args){
        KromrakForm kromrakForm = new KromrakForm();
        kromrakForm.prepareGUI();
        Scanner scanner = new Scanner(System.in);

        //Test combat
        //Combat.getInstance().newCombat().combattre();

        //test salle avec combat :
        //Kromrak.getInstance().setSalle(new Salle(new Coord(2,2)));
        //Kromrak.getInstance().setSalle(new Salle());

        //Test zone avec salle avec combat (sans déplacement)
        Zone zone = new Zone();
        zone.entree.activer();
        zone.getSalle(new Coord(1,0)).activer();
        zone.getSalle(new Coord(0,0)).activer();

        //Test thread
        //Il faut juste envoyer un objet qui implémente "runable" en paramètre.
        //Thread threadTest = new Thread(new Salle(new Coord(0,0)));
        //threadTest.start();
        //threadTest.interrupt();

        System.out.println(Kromrak.getInstance().toString() + System.lineSeparator() +
                System.lineSeparator() + "Appuyez sur 'Enter' pour continuer.");;
        scanner.nextLine();
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

        KeepBarsUpdated keepBarsUpdated = new KeepBarsUpdated(barreVie, barreVit);
        keepBarsUpdated.start();
    }
}
