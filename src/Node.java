import java.util.ArrayList;

public class Node extends Object {
    static double dv, di, dt, t;
    String name;
    double voltage, V_n;
    ArrayList<Properties> properties = new ArrayList<>();
    boolean added;
    boolean isGround = false;
    int union;
    Node parentNode;
    ArrayList<Node> children = new ArrayList<>();
    TwoPort connector;
    boolean isConnectorInverse;
    ArrayList<Node> neighbor = new ArrayList<>();
    ArrayList<TwoPort> connected = new ArrayList<>();


    Node(String name) {
        this.name = name;
        this.voltage = 0;
        this.V_n = 0;
        this.union = Integer.parseInt(name);
        if (name.equals("0")) {
            isGround = true;
        }
    }

    static void addNode(TwoPort element, ArrayList<Node> nodes) {
        int startNodeIndex = -1, endNodeIndex = -1;
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).name.equals(element.startNode)) {
                startNodeIndex = i;
            } else if (nodes.get(i).name.equals(element.endNode)) {
                endNodeIndex = i;
            }
        }
        if (startNodeIndex < 0) {
            nodes.add(new Node(element.startNode));
            startNodeIndex = nodes.size() - 1;
        }
        if (endNodeIndex < 0) {
            nodes.add(new Node(element.endNode));
            endNodeIndex = nodes.size() - 1;
        }
        element.startTerminal = nodes.get(startNodeIndex);
        element.endTerminal = nodes.get(endNodeIndex);
        nodes.get(startNodeIndex).connected.add(element);
        nodes.get(endNodeIndex).connected.add(element);
        nodes.get(startNodeIndex).neighbor.add(nodes.get(endNodeIndex));
        nodes.get(endNodeIndex).neighbor.add(nodes.get(startNodeIndex));
    }

    void setParent(Node parent) {
        this.parentNode = parent;
    }
}
