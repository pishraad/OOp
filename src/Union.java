import java.util.ArrayList;

public class Union {
    int name;
    ArrayList<Node> nodes = new ArrayList<>();

    Union(int name){
        this.name = name;
    }

    static ArrayList<Union> unionMaker(ArrayList<TwoPort> elements, ArrayList<Node> nodes) {
        ArrayList<Union> unions = new ArrayList<>() ;
        boolean isDone = false;
        while (!isDone) {
            isDone = true;
            for (TwoPort element : elements) {
                if (element.type == 'V' || element.type == 'v' /*to be continued*/) {
                    if (element.startTerminal.union != element.endTerminal.union) {
                        isDone = false;
                        element.endTerminal.union = element.startTerminal.union;
                    }
                }
            }
        }
        Union union;
        for(Node node : nodes){
            if(!node.added) {
                union = new Union(node.union);
                for (Node otherNode : nodes) {
                    if (otherNode.union == node.union) {
                        union.nodes.add(otherNode);
                        otherNode.added = true;
                    }
                }
                unions.add(union);
            }
        }
        return unions;
    }

}