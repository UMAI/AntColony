package Backend;

import GUI.AntColonyWindow;
import java.awt.*;

public class CalculatingMachine {
    AntColonyWindow antColonyWindow;
    Graph graph;

    public CalculatingMachine(AntColonyWindow acw) {
        this.antColonyWindow = acw;
    }

    public void start() {
        int numberOfNodes = (int)antColonyWindow.settingsPanel.numberOfNodes.getValue();
        int numberOfFoodNodes = (int)antColonyWindow.settingsPanel.numberOfFoodNodes.getValue();
        int numberOfEdges = (int)antColonyWindow.settingsPanel.numberOfEdges.getValue();
        int numberOfAnts = (int)antColonyWindow.settingsPanel.numberOfAnts.getValue();
        int width = (int)antColonyWindow.displayPanel.getPreferredSize().getWidth();
        int height = (int)antColonyWindow.displayPanel.getPreferredSize().getHeight();

        graph = new Graph(numberOfNodes);
        graph.generateNodes(numberOfFoodNodes, width, height);
        graph.generateEdges(numberOfEdges);
        generateAnts(numberOfAnts);
        antColonyWindow.displayPanel.update(graph.nodes, graph.adjacencyMatrix, graph.antsPositions);
    }

    private void generateAnts(int numberOfAnts) {
        int j = 0;
        while (!graph.nodes[j].isAnthill()) j++;
        for (int i = 0; i < numberOfAnts; i++) {
            graph.antsPositions[i] = new Point(graph.nodes[j].getX(), graph.nodes[j].getY());
        }
    }
}
