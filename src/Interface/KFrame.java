package Interface;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lamg030499 on 2017-09-06.
 */
public class KFrame extends JFrame{

    public DescPanel descPanel = new DescPanel();
    public TextPanel textPanel = new TextPanel();

    private static KFrame kFrame = new KFrame();

    public static KFrame getInstance() {
        return kFrame;
    }

    private KFrame() {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setLocation(300, 300);
        this.setBackground(Color.blue);
        this.setLocationRelativeTo(null);
        this.setTitle("KROMRAK LE KROMRAK:L'APPLICATION");
        //this.setResizable(false);

        this.add(descPanel);
        this.add(textPanel);
        this.setVisible(true);
        //DescPanel descPanel = new DescPanel();
        //this.add(descPanel);
    }


}
