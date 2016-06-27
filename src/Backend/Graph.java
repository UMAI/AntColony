package Backend;

import java.util.HashSet;
import java.util.Random;

public class Graph {
    Node[] nodes;
    int[][] adjacencyMatrix;

    public Graph(int numberOfNodes) {
        nodes = new Node[numberOfNodes];
        adjacencyMatrix = new int[numberOfNodes][numberOfNodes];
    }

    public Graph(Node[] nodes) {
        this.nodes = nodes;
    }

    public double edgeLength(Node n1, Node n2) {
        return Math.sqrt(Math.pow(n1.getX()-n2.getX(), 2) + Math.pow(n1.getY()-n2.getY(), 2));
    }

    public double edgeLength(int i, int j) {
        return Math.sqrt(Math.pow(nodes[i].getX()-nodes[j].getX(), 2) + Math.pow(nodes[i].getY()-nodes[j].getY(), 2));
    }

    public void addEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
    }

    public void addEdge(Node n1, Node n2) {
        int i = 0, j = 0;
        while (nodes[i] != n1) i++;
        while (nodes[j] != n2) j++;
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
    }

    public void generateNodes(int numberOfFoodNodes, int width, int height) {

        Random random = new Random();
        for (int i = 0; i < nodes.length; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int amountOfFood = 0;
            if (i < numberOfFoodNodes)
                amountOfFood = random.nextInt(40) + 1;
            nodes[i] = new Node(x, y, amountOfFood);
        }
    }

    public void generateEdges(int numberOfEdges) {
        primsAlgorithm();
    }

    private void primsAlgorithm() {
        HashSet<Node> chosenNodes = new HashSet<>();
        HashSet<Node> unchosenNodes = new HashSet<>();
        double min = Double.MAX_VALUE;
        int minJ = 0;

        //finding minimal edge incident from the first node
        for (int j = 1; j < nodes.length; j++) {
            if (edgeLength(nodes[0], nodes[j]) < min) {
                min = edgeLength(nodes[0], nodes[j]);
                minJ = j;
            }
            unchosenNodes.add(nodes[j]);
        }
        adjacencyMatrix[0][minJ] = 1;
        chosenNodes.add(nodes[0]);
        chosenNodes.add(nodes[minJ]);
        unchosenNodes.remove(nodes[minJ]);

        Node minNode1 = null, minNode2 = null;
        while (chosenNodes.size() < nodes.length) {
            min = Double.MAX_VALUE;
            for (Node node1 : chosenNodes) {
                for (Node node2 : unchosenNodes) {
                    if (edgeLength(node1, node2) < min) {
                        min = edgeLength(node1, node2);
                        minNode1 = node1;
                        minNode2 = node2;
                    }
                }
            }
            addEdge(minNode1, minNode2);
            chosenNodes.add(minNode2);
            unchosenNodes.remove(minNode2);
        }
    }
}
