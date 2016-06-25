package GUI;

import Backend.CalculatingMachine;

import javax.swing.*;
import java.awt.*;

public class AntColonyWindow extends JFrame{
    public Container contentPane;
    public DisplayPanel displayPanel;
    public SettingsPanel settingsPanel;
    public CalculatingMachine calculatingMachine;

    public AntColonyWindow() {
        super("Ant Colony");
        initialize();
        addElements();
        setVisible(true);
    }

    private void initialize() {
        setSize(1920, 1080);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBackground(new Color(255,255,255));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void addElements() {
        contentPane = getContentPane();
        contentPane.add(displayPanel = new DisplayPanel(this), BorderLayout.LINE_START);
        contentPane.add(settingsPanel = new SettingsPanel(this), BorderLayout.LINE_END);
    }
}
