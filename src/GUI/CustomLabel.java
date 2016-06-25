package GUI;

import javax.swing.*;
import java.awt.*;

public class CustomLabel extends JLabel {
    public CustomLabel(String text, JPanel panel) {
        super(text);
        setPreferredSize(new Dimension((int)panel.getPreferredSize().getWidth()-130, 40));
        setFont(new Font("Verdana", Font.PLAIN, 20));
    }
}
