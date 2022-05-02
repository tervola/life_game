package home.pet.life;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private int x,y;
    private boolean alive;
    private boolean nextStepAlive;
    private List<Node> neighborsLife = new ArrayList<>();

    public Node(int x, int y, boolean alive) {
        this.x = x;
        this.y = y;
        this.alive = alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setNextStepAlive(boolean nextStepAlive) {
        this.nextStepAlive = nextStepAlive;
    }

    public void addNeighborsLife(Node neighbor) {
        this.neighborsLife.add(neighbor);
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isNextStepAlive() {
        return nextStepAlive;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getNeighborsLifeSize() {
        return neighborsLife.size();
    }

    @Override
    public String toString() {
        return isAlive() ? "1" : "0";
    }

    public void reset(){
        neighborsLife.clear();
    }
}
