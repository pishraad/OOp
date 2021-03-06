import java.util.ArrayList;

public class Union {
    static double dv, di, dt, t;
    int name;
    Node mainNode;
    ArrayList<Node> nodes = new ArrayList<>();
    boolean visited;
    double I_n, I, I_p;


    Union(int name) {
        this.name = name;
    }

    static ArrayList<Union> unionMaker(ArrayList<TwoPort> elements, ArrayList<Node> nodes) {
        ArrayList<Union> unions = new ArrayList<>();
        boolean isDone = false;
        while (!isDone) {
            isDone = true;
            for (TwoPort element : elements) {
                if (element.type == 'V' || element.type == 'H' || element.type == 'E') {
                    if (element.startTerminal.union != element.endTerminal.union) {
                        isDone = false;
                        Node startTerminal = element.startTerminal;
                        Node endTerminal = element.endTerminal;
                        if (startTerminal.union < endTerminal.union) {
                            endTerminal.union = startTerminal.union;
                            endTerminal.setParent(startTerminal);
                            endTerminal.connector = element;
                            endTerminal.isConnectorInverse = false;
                            startTerminal.children.add(endTerminal);
                        } else {
                            startTerminal.union = endTerminal.union;
                            startTerminal.setParent(endTerminal);
                            startTerminal.connector = element;
                            startTerminal.isConnectorInverse = true;
                            endTerminal.children.add(startTerminal);
                        }
                    }
                }
            }
        }
        Union union;
        boolean isMain;
        for (Node node : nodes) {
            if (!node.added) {
                union = new Union(node.union);
                for (Node otherNode : nodes) {
                    if (otherNode.union == node.union) {
                        union.nodes.add(otherNode);
                        otherNode.added = true;
                        isMain = true;
                        for (Node otherUnionNode : union.nodes) {
                            if (Integer.parseInt(otherUnionNode.name) < Integer.parseInt(otherNode.name)) {
                                isMain = false;
                            }
                        }
                        if (isMain) {
                            union.mainNode = otherNode;
                        }
                    }
                }
                unions.add(union);
            }
        }
        return unions;
    }

    void updateVoltage(double t) {
        for (Node n : nodes) {
            if (n.parentNode != null) {
                n.connector.voltageCalculator(t);
                n.voltage = n.isConnectorInverse ? n.parentNode.voltage - n.connector.voltage : n.parentNode.voltage + n.connector.voltage;
            }
        }
    }

}