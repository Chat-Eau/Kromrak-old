package Interface.Objets;
import Interface.KFrame;
import javax.swing.*;

public class JKromrakHideButton extends JButton{
    public JKromrakHideButton(){
        super();
        this.addActionListener(e -> KFrame.getInstance().setState(JFrame.ICONIFIED));
    }
    public JKromrakHideButton(Icon icon) {
        super(icon);
        this.addActionListener(e -> KFrame.getInstance().setState(JFrame.ICONIFIED));
    }
}
