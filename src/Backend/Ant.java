package Backend;

public class Ant extends Thread {
    private CalculatingMachine calculatingMachine;
    private double x, y, dx, dy, destx, desty;
    private int index;
    private Graph graph;

    public Ant(int index, CalculatingMachine calculatingMachine, Graph graph, double x, double y) {
        this.index = index;
        this.calculatingMachine = calculatingMachine;
        this.graph = graph;
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        while (true) {
            determineMovementVector();
            while (x != destx || y != desty) {
                x += dx;
                y += dy;
                graph.updatePosition(index, dx, dy);
            }
        }
    }

    private void determineMovementVector() {

    }
}
