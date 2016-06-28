package Backend;

import java.awt.*;

public class Node {
    private int x, y, amountOfFood;
    private Color color;
    private boolean anthill;

    public Node() {
        x = 0;
        y = 0;
        amountOfFood = 0;
        color = Color.black;
    }

    public Node(int x, int y, int amountOfFood, boolean anthill) {
        this.x = x;
        this.y = y;
        this.amountOfFood = amountOfFood;
        this.anthill = anthill;
        if (amountOfFood == 0)
            this.color = Color.white;
        else
            this.color = new Color(255, 205 - amountOfFood*5, 205 - amountOfFood*5);
    }

    public boolean isFoodNode() {
        return amountOfFood > 0;
    }

    public boolean isAnthill() { return anthill; }

    public void consume() {
        amountOfFood--;
        this.color = new Color(5*amountOfFood, 0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }
}
