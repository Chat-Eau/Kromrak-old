package Interface;

import sun.security.krb5.internal.crypto.Des;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lamg030499 on 2017-09-06.
 */
public class KFrame extends JFrame{

    public DescPanel descPanel = new DescPanel();

    public KFrame() {
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        this.setLocation(300, 300);
        this.setBackground(Color.blue);
        this.setLocationRelativeTo(null);
        this.setTitle("KROMRAK LE KROMRAK:L'APPLICATION");
        this.setResizable(false);

        this.add(descPanel);
        this.setVisible(true);
        //DescPanel descPanel = new DescPanel();
        //this.add(descPanel);
    }
}
