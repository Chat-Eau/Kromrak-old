package Interface;

import javax.swing.*;
import java.awt.*;
import Outils.Constantes;
/**
 * Created by lamg030499 on 2017-09-06.
 */
public class KFrame extends JFrame{
    private static KFrame kFrame = new KFrame();

    public static KFrame getInstance() {
        return kFrame;
    }

    public DescPanel descPanel;
    public TextPanel textPanel;

    protected int width;
    protected int height;

    private KFrame() {
        height = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
        width = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();

        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setResizable(false);
        this.setLocation(0, 0);
        this.setBackground(Color.blue);
        this.setLocationRelativeTo(null);
        this.setTitle("KROMRAK LE KROMRAK:L'APPLICATION");
        this.setVisible(true);
    }

    public void openDescPanel(boolean visible){
        if (this.descPanel == null){
            this.descPanel = new DescPanel();
            this.add(descPanel);
        }
        this.descPanel.setVisible(visible);
    }
    public void openTextPanel(boolean visible){
        if (this.textPanel == null){
            this.textPanel = new TextPanel();
            this.add(textPanel);
        }
        this.textPanel.setVisible(visible);
    }
}
