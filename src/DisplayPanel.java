import java.awt.*;

public class DisplayPanel extends Panel{
    public DisplayPanel(AntColonyWindow acw) {
        setSize(acw.getWidth()*3/4, acw.getHeight());
        setBackground(new Color(100, 50, 0));
        setVisible(true);
    }
}
