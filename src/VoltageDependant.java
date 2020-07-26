public class VoltageDependant extends TwoPort {
    String startDependantNode;
    String endDependantNode;
    double factor;

    VoltageDependant(String input){
        input = input.replaceAll("\\s+"," ");
        String[] temp = input.split(" ");
        name = temp[0];
        startNode = temp[1];
        endNode = temp[2];
        startDependantNode = temp[3];
        endDependantNode = temp[4];
        factor = toDouble(temp[5]);
    }
}
