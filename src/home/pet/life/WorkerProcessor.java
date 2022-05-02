package home.pet.life;

import java.util.Map;

public class WorkerProcessor {

    private final Map<String, Node> mapNodes;
    private final int area;

    public WorkerProcessor(Map<String, Node> mapNodes, int area) {
        this.mapNodes = mapNodes;
        this.area = area;
    }


    public void defineNeighborsLife(Node node) {
        calculateLeftUp(node);
        calculateAbove(node);
        calculateRightUp(node);
        calculateLeft(node);
        calculateRight(node);
        calculateBottomLeft(node);
        calculateUnder(node);
        calculateBottomRight(node);
    }

    private void calculateLeftUp(Node node) {
        if (node.getY() != 0) {
            if (node.getX() != 0) {
                String key = String.valueOf(node.getX() - 1) + (node.getY() - 1);
                if (mapNodes.get(key).isAlive()) {
                    node.addNeighborsLife(mapNodes.get(key));
                }
            }
        }
    }

    private void calculateAbove(Node node) {
        if (node.getY() != 0) {
            String key = String.valueOf(node.getX()) + (node.getY() - 1);

            if (mapNodes.get(key).isAlive()) {
                node.addNeighborsLife(mapNodes.get(key));
            }
        }
    }

    private void calculateRightUp(Node node) {
        if (node.getY() != 0) {
            if (node.getX() != area - 1) {
                String key = String.valueOf(node.getX() + 1) + (node.getY() - 1);
                if (mapNodes.get(key).isAlive()) {
                    node.addNeighborsLife(mapNodes.get(key));
                }
            }
        }
    }

    private void calculateLeft(Node node) {
        if (node.getX() != 0) {
            String key = String.valueOf(node.getX() - 1) + node.getY();
            if (mapNodes.get(key).isAlive()) {
                node.addNeighborsLife(mapNodes.get(key));
            }
        }
    }

    private void calculateRight(Node node) {
        if (node.getX() != area - 1) {
            String key = String.valueOf(node.getX() + 1) + (node.getY());
            if (mapNodes.get(key).isAlive()) {
                node.addNeighborsLife(mapNodes.get(key));
            }
        }
    }

    private void calculateBottomLeft(Node node) {
        if (node.getY() != area - 1) {
            if (node.getX() != 0) {
                String key = String.valueOf(node.getX() - 1) + (node.getY() + 1);
                if (mapNodes.get(key).isAlive()) {
                    node.addNeighborsLife(mapNodes.get(key));
                }
            }
        }
    }

    private void calculateUnder(Node node) {
        if (node.getY() != area - 1) {
            String key = String.valueOf(node.getX()) + (node.getY() + 1);
            if (mapNodes.get(key).isAlive()) {
                node.addNeighborsLife(mapNodes.get(key));
            }
        }
    }

    private void calculateBottomRight(Node node) {
        if (node.getY() != area - 1) {
            if (node.getX() != area - 1) {
                String key = String.valueOf(node.getX() + 1) + (node.getY() + 1);
                if (mapNodes.get(key).isAlive()) {
                    node.addNeighborsLife(mapNodes.get(key));
                }
            }
        }
    }
}
