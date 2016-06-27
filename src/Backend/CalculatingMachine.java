package Backend;

import GUI.AntColonyWindow;

import java.util.HashSet;
import java.util.Random;

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
        int width = (int)antColonyWindow.displayPanel.getPreferredSize().getWidth();
        int height = (int)antColonyWindow.displayPanel.getPreferredSize().getHeight();

        graph = new Graph(numberOfNodes);
        graph.generateNodes(numberOfFoodNodes, width, height);
        graph.generateEdges(numberOfEdges);
        generateAnts();
        antColonyWindow.displayPanel.update(graph.nodes, graph.adjacencyMatrix);
    }

    private void generateAnts() {

    }
}
