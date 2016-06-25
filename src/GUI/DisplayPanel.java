package GUI;

import java.awt.*;

public class DisplayPanel extends Panel {
    private Graphics graphics;

    public DisplayPanel(AntColonyWindow acw) {
        graphics = getGraphics();
        setPreferredSize(new Dimension(acw.getWidth()*3/4, acw.getHeight()));
        setBackground(new Color(100, 50, 0));
        setVisible(true);
    }

    public void update() {

    }
}
