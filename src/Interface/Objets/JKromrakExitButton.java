package Interface.Objets;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JKromrakExitButton extends JButton{
    public JKromrakExitButton(){
        super();
        this.addActionListener(e -> System.exit(0));
    }
    public JKromrakExitButton(Icon icon) {
        super(icon);
        this.addActionListener(e -> System.exit(0));
    }
}
