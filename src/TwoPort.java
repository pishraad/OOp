import java.util.ArrayList;

public abstract class TwoPort {

    static double dv, di, dt, t;
    String name;
    String startNode;
    String endNode;
    Node startTerminal;
    Node endTerminal;
    double value;
    char type;
    boolean isDraw = false;
    double current, I_p, I_n;
    double voltage;
    ArrayList<Properties> properties = new ArrayList<>();

    TwoPort() {
    }

    TwoPort(String input) {
        input = input.replaceAll("\\s+", " ");
        String[] temp = input.split(" ");
        name = temp[0];
        startNode = temp[1];
        endNode = temp[2];
        value = toDouble(temp[3]);
        current = 0;
        I_n = 0;
    }

    static double toDouble(String input) {
        double out;
        if (Character.isAlphabetic(input.charAt(input.length() - 1))) {
            out = Double.parseDouble(input.substring(0, input.length() - 1));
            char last = input.charAt(input.length() - 1);
            if (last == 'p') {
                out /= Math.pow(10, 12);
            } else if (last == 'n') {
                out /= Math.pow(10, 9);
            } else if (last == 'u') {
                out /= Math.pow(10, 6);
            } else if (last == 'm') {
                out /= Math.pow(10, 3);
            } else if (last == 'k') {
                out *= Math.pow(10, 3);
            } else if (last == 'M') {
                out *= Math.pow(10, 6);
            } else if (last == 'G') {
                out *= Math.pow(10, 9);
            }
        } else {
            out = Double.parseDouble(input);
        }
        return out;
    }

    abstract double currentCalculator();

    abstract double currentDvCalculator(double dv);

    double voltageCalculator(double t) {
        voltage = startTerminal.voltage - endTerminal.voltage;
        return voltage;
    }


}

class Properties {

    double voltage;
    double current;
    double power;
    double time;

    Properties(double time) {
        this.time = time;
    }
}