import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VoltageSource extends Source {
    @Override
    double currentCalculator() {
        return 0;
    }

    VoltageSource(String input) {
        super(input);
        type = 'V';
    }

    double voltageCalculator(double t){
        return value + amplitude * Math.cos(2 * Math.PI * frequency * t + phase);
    }
}

class CDVoltageSource extends CurrentDependant {

    @Override
    double currentCalculator() {
        return 0;
    }

    CDVoltageSource(String input) {
        super(input);
        type = 'H';
    }
}

class VDVoltageSource extends VoltageDependant {
    @Override
    double currentCalculator() {
        return 0;
    }

    VDVoltageSource(String input) {
        super(input);
        type = 'E';
    }
}
