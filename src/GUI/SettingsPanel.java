package GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class SettingsPanel extends JPanel {
    public JSpinner numberOfAnts, numberOfNodes, numberOfFoodNodes;
    public AntColonyWindow antColonyWindow;

    public SettingsPanel(AntColonyWindow acw) {
        initialize(acw);
        addElements();
        setVisible(true);
    }

    private void initialize(AntColonyWindow acw) {
        setPreferredSize(new Dimension(acw.getWidth()/4, acw.getHeight()));
        setBackground(new Color(150, 150, 150));
        TitledBorder border = new TitledBorder("Settings");
        border.setTitleFont(new Font("Verdana", Font.BOLD, 25));
        border.setTitleJustification(TitledBorder.CENTER);
        this.setBorder(border);
        this.antColonyWindow = acw;
    }

    private void addElements() {
        numberOfAnts = new CustomSpinner(new SpinnerNumberModel(1, 1, 1000, 1));
        JPanel ants = new CustomPanel(this);
        ants.add(new CustomLabel("Number of ants: ", ants));
        ants.add(numberOfAnts);

        numberOfNodes = new CustomSpinner(new SpinnerNumberModel(1, 1, 10000, 1));
        JPanel nodes = new CustomPanel(this);
        nodes.add(new CustomLabel("Number of nodes: ", nodes));
        nodes.add(numberOfNodes);

        numberOfFoodNodes = new CustomSpinner(new SpinnerNumberModel(1, 1, 10000, 1));
        JPanel foodNodes = new CustomPanel(this);
        foodNodes.add(new CustomLabel("Number of food nodes: ", foodNodes));
        foodNodes.add(numberOfFoodNodes);

        add(ants, BorderLayout.PAGE_START);
        add(nodes, BorderLayout.CENTER);
        add(foodNodes, BorderLayout.CENTER);
        add(new StartButton(antColonyWindow), BorderLayout.PAGE_END);
    }
}
