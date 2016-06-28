package GUI;

import Backend.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class DisplayPanel extends JPanel {
    private Node[] nodes;
    private int[][] adjacencyMatrix;
    private Point[] antsPositions;

    public DisplayPanel(AntColonyWindow acw) {
        setPreferredSize(new Dimension(acw.getWidth()*3/4, acw.getHeight()));
        setBackground(new Color(100, 50, 0));
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getBackground());
        g.drawRect(0, 0, getWidth(), getHeight());
        if (nodes != null) {
            Graphics2D g2 = (Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                for (int j = i; j < adjacencyMatrix.length; j++) {
                    if (adjacencyMatrix[i][j] == 1) {
                        g2.setColor(Color.white);
                        g2.drawLine(nodes[i].getX(), nodes[i].getY(), nodes[j].getX(), nodes[j].getY());
                    }
                }
            }

            for (int i = 0; i < nodes.length; i++) {
                g2.setColor(nodes[i].getColor());
                Ellipse2D.Double oval = new Ellipse2D.Double(nodes[i].getX()-3.5, nodes[i].getY()-3.5, 7, 7);
                g2.fill(oval);
            }
        }
    }

    public void update(Node[] nodes, int[][] adjacencyMatrix, Point[] antsPositions) {
        this.nodes = nodes;
        this.adjacencyMatrix = adjacencyMatrix;
        this.antsPositions = antsPositions;
        repaint();
    }
}
