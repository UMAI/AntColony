import javax.swing.*;
import java.awt.*;

public class AntColonyWindow extends JFrame{
    protected Container contentPane;

    public AntColonyWindow() {
        super("ANT COLONY");
        initialize();
        addElements();
    }

    protected void initialize() {
        setSize(1920, 1080);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setBackground(new Color(255,255,255));
        setVisible(true);
    }

    protected void addElements() {
        contentPane = getContentPane();
        contentPane.add(new DisplayPanel(this));
        contentPane.add(new SettingsPanel(this));
    }
}
