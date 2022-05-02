package home.pet.life;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Terra {
    private final List<Node> nodes = new ArrayList<>();
    private final int area;
    private final WorkerProcessor worker;
    private final Map<String, Node> mapNodes = new HashMap();

    public Terra(int area) {
        this.area = area;
        for (int y = 0; y < area; y++) {
            for (int x = 0; x < area; x++) {
                final Node node = new Node(x, y, new Random().nextBoolean());
                mapNodes.put(String.valueOf(x) + y, node);
                nodes.add(node);
            }
        }

        worker = new WorkerProcessor(mapNodes, area);
    }

    public void depict() {
        for (int i = 0; i < nodes.size(); i++) {
            System.out.print(String.format("%-3s", nodes.get(i)));
            if ((i + 1) % area == 0) {
                System.out.println();
            }
        }
    }

    private void checkNeighbors() {
        for (Node node : nodes) {
            worker.defineNeighborsLife(node);

            if (node.isAlive()) {
                node.setNextStepAlive(node.getNeighborsLifeSize() >= 2 && node.getNeighborsLifeSize() <= 3);
            } else {
                node.setNextStepAlive(node.getNeighborsLifeSize() == 3);
            }
        }
    }

    private void updateStep() {
        for (Node node : nodes) {
            node.setAlive(node.isNextStepAlive());
            node.reset();
        }
    }

    public void start(int age) {
        for (int i = 0; i < age; i++) {
            checkNeighbors();
            updateStep();
            System.out.println("===== iteration: " + i);
            depict();
        }
    }
}
