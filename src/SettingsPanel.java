import java.awt.*;

public class SettingsPanel extends Panel{
    public SettingsPanel(AntColonyWindow acw) {
        setSize(acw.getWidth()*1/4, acw.getHeight());
        setBackground(new Color(150, 150, 150));
        setVisible(true);
    }
}
