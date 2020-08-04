import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VoltageSource extends Source {
    @Override
    double currentCalculator() {
        return 0;
    }

    @Override
    double currentDvCalculator(double dv) {
        return 0;
    }

    VoltageSource(String input) {
        super(input);
        type = 'V';
    }

    double voltageCalculator(double t){
        voltage = value + amplitude * Math.cos(2 * Math.PI * frequency * t + phase);
        return voltage;
    }
}

class CDVoltageSource extends CurrentDependant {

    @Override
    double currentCalculator() {
        return 0;
    }

    @Override
    double currentDvCalculator(double dv) {
        return 0;
    }

    double voltageCalculator(double t){
        voltage = gain * (elementDependant.currentCalculator());
        return voltage;
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

    @Override
    double currentDvCalculator(double dv) {
        return 0;
    }

    double voltageCalculator(double t) {
        voltage = gain * (startDependant.voltage - endDependant.voltage);
        return voltage;
    }

    VDVoltageSource(String input) {
        super(input);
        type = 'E';
    }
}
