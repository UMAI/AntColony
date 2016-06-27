package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButton extends JButton implements ActionListener {
    public AntColonyWindow antColonyWindow;

    public StartButton(AntColonyWindow antColonyWindow) {
        setPreferredSize(new Dimension(100, 40));
        setBackground(Color.white);
        setFont(new Font("Verdana", Font.PLAIN, 20));
        setText("START");
        addActionListener(this);
        this.antColonyWindow = antColonyWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        antColonyWindow.calculatingMachine.start();
    }
}
