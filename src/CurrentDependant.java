public class CurrentDependant extends TwoPort {
    String element;
    double factor;

    CurrentDependant(String input){
        input = input.replaceAll("\\s+"," ");
        String[] temp = input.split(" ");
        name = temp[0];
        startNode = temp[1];
        endNode = temp[2];
        element = temp[3];
        factor = toDouble(temp[4]);
    }


}
