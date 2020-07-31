import java.util.ArrayList;

public class VoltageDependant extends TwoPort {
    String startDependantNode;
    String endDependantNode;
    double factor;
    String element;

    public void element(ArrayList<Node> node) {
        for (Node i : node){
            if (i.name.equals(startDependantNode)){
                for (TwoPort j : i.connected){
                    if (j.endNode.equals(endDependantNode) || j.startNode.equals(endDependantNode)){
                        element = j.name ;
                    }
                }
            }
        }
    }

    VoltageDependant(String input,ArrayList<Node> node) {
        input = input.replaceAll("\\s+", " ");
        String[] temp = input.split(" ");
        name = temp[0];
        startNode = temp[1];
        endNode = temp[2];
        startDependantNode = temp[3];
        endDependantNode = temp[4];
        factor = toDouble(temp[5]);
        element(node) ;
    }


    public void CCVC(CurrentDependant currentDependant, ArrayList<TwoPort> elements) {

        if (element.charAt(0) == 'I') {
            String element1 = element.substring(1);
            for (TwoPort i : elements) {
                if (element1.equals(i.name)) {
                    value = currentDependant.factor * i.current(i);
                }
            }
        }

        if (element.charAt(0) == 'L') {
            String element1 = element.substring(1);
            for (TwoPort i : elements) {
                if (element1.equals(i.name)) {
                    value = currentDependant.factor * i.current(i);
                }
            }
        }

        if (element.charAt(0) == 'C') {
            String element1 = element.substring(1);
            for (TwoPort i : elements) {
                if (element1.equals(i.name)) {
                    value = currentDependant.factor * i.current(i);
                }
            }
        }
        if (element.charAt(0) == 'R') {
            String element1 = element.substring(1);
            for (TwoPort i : elements) {
                if (element1.equals(i.name)) {
                    value = currentDependant.factor * i.current(i);
                }
            }
        }

    }


    public void VCVC(CurrentDependant currentDependant, ArrayList<TwoPort> elements) {

        if (element.charAt(0) == 'I') {
            String element1 = element.substring(1);
            for (TwoPort i : elements) {
                if (element1.equals(i.name)) {
                    value = currentDependant.factor * i.voltage(i);
                }
            }
        }

        if (element.charAt(0) == 'R') {
            String element1 = element.substring(1);
            for (TwoPort i : elements) {
                if (element1.equals(i.name)) {
                    value = currentDependant.factor * i.voltage(i);
                }
            }
        }

        if (element.charAt(0) == 'L') {
            String element1 = element.substring(1);
            for (TwoPort i : elements) {
                if (element1.equals(i.name)) {
                    value = currentDependant.factor * i.voltage(i);
                }
            }
        }

        if (element.charAt(0) == 'C') {
            String element1 = element.substring(1);
            for (TwoPort i : elements) {
                if (element1.equals(i.name)) {
                    value = currentDependant.factor * i.voltage(i);
                }
            }
        }
    }

}
