package GUI;

import javax.swing.*;
import java.awt.*;

public class CustomPanel extends JPanel {
    public CustomPanel(SettingsPanel panel) {
        setPreferredSize(new Dimension((int)panel.getPreferredSize().getWidth()-6, 40));
        setBackground(panel.getBackground());
    }
}
