public class Source extends TwoPort {
    double amplitude;
    double frequency;
    double phase;

    Source(String input) {
        input = input.replaceAll("\\s+"," ");
        String[] temp = input.split(" ");
        name = temp[0];
        startNode = temp[1];
        endNode = temp[2];
        value = toDouble(temp[3]);
        amplitude = toDouble(temp[4]);
        frequency = toDouble(temp[5]);
        phase = toDouble(temp[6]);

    }
}