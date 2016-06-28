package Backend;

import java.awt.*;
import java.util.HashSet;
import java.util.Random;

public class Graph {
    Node[] nodes;
    int[][] adjacencyMatrix;
    CustomPoint[] antsPositions;

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
        int anthill = random.nextInt(nodes.length);
        for (int i = 0; i < nodes.length; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height - 100);
            int amountOfFood = 0;
            if (i < numberOfFoodNodes)
                amountOfFood = random.nextInt(40) + 1;
            if (i != anthill)
                nodes[i] = new Node(x, y, amountOfFood, false);
            else
                nodes[i] = new Node(x, y, amountOfFood, true);
        }
    }

    public void generateEdges(int numberOfEdges) {
        primsAlgorithm();
        Random random = new Random();
        int i = nodes.length;
        while (i < numberOfEdges) {
            int first = random.nextInt(nodes.length);
            int second = random.nextInt(nodes.length);
            if ((first != second) && (adjacencyMatrix[first][second] == 0) && (!intersectsExistingEdges(first, second))) {
                adjacencyMatrix[first][second] = 1;
                adjacencyMatrix[second][first] = 1;
                i++;
            }
        }
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
        adjacencyMatrix[minJ][0] = 1;
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

    private boolean intersectsExistingEdges(int first, int second) {
        boolean result = false;
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes.length; j++) {
                if ((i != first) && (i != second) && (j != first) && (j != second) &&
                        (adjacencyMatrix[i][j] == 1) && (checkIntersection(nodes[first], nodes[second], nodes[i], nodes[j]))) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    private boolean checkIntersection(Node a, Node b, Node c, Node d) {
        double v1 = (d.getX()-c.getX())*(a.getY()-c.getY()) - (d.getY()-c.getY())*(a.getX()-c.getX());
        double v2 = (d.getX()-c.getX())*(b.getY()-c.getY()) - (d.getY()-c.getY())*(b.getX()-c.getX());
        double v3 = (b.getX()-a.getX())*(c.getY()-a.getY()) - (b.getY()-a.getY())*(c.getX()-a.getX());
        double v4 = (b.getX()-a.getX())*(d.getY()-a.getY()) - (b.getY()-a.getY())*(d.getX()-a.getX());
        return (v1*v2<0)&&(v3*v4<0);
    }

    public void updatePosition(int index, double dx, double dy) {
        antsPositions[index].move(dx, dy);
    }
}
