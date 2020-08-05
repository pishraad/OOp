public abstract class Source extends TwoPort {
    double amplitude;
    double frequency;
    double phase;

    Source(String input) {
        input = input.replaceAll("\\s+", " ");
        String[] temp = input.split(" ");
        name = temp[0];
        type = temp[0].charAt(0);
        startNode = temp[1];
        endNode = temp[2];
        value = toDouble(temp[3]);
        amplitude = toDouble(temp[4]);
        frequency = toDouble(temp[5]);
        phase = toDouble(temp[6]);

    }
}

abstract class VoltageDependant extends TwoPort {
    String startDependantNode;
    String endDependantNode;
    Node startDependant;
    Node endDependant;
    double gain;

    VoltageDependant(String input) {
        input = input.replaceAll("\\s+", " ");
        String[] temp = input.split(" ");
        name = temp[0];
        startNode = temp[1];
        endNode = temp[2];
        startDependantNode = temp[3];
        endDependantNode = temp[4];
        gain = toDouble(temp[5]);
    }

}

abstract class CurrentDependant extends TwoPort {
    String elementDependantName;
    TwoPort elementDependant;
    double gain;

    CurrentDependant(String input) {
        input = input.replaceAll("\\s+", " ");
        String[] temp = input.split(" ");
        name = temp[0];
        startNode = temp[1];
        endNode = temp[2];
        elementDependantName = temp[3];
        gain = toDouble(temp[4]);
    }

}