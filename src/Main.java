import Backend.CalculatingMachine;
import GUI.AntColonyWindow;

public class Main {
    public static void main(String[] args) {
        AntColonyWindow window = new AntColonyWindow();
        CalculatingMachine machine = new CalculatingMachine(window);
        window.calculatingMachine = machine;
    }
}
