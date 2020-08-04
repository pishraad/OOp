public class CurrentSource extends Source {
    @Override
    double currentCalculator() {
        return 0;
    }

    @Override
    double currentDvCalculator(double dv) {
        return 0;
    }

    CurrentSource(String input){
        super(input);
        type = 'I';
    }

    double currentCalculator(double t){
        return value + amplitude * Math.cos(2 * Math.PI * frequency * t + phase);
    }
}
class CDCurrentSource extends  CurrentDependant {
    @Override
    double currentCalculator() {
        return gain * (elementDependant.currentCalculator());
    }

    @Override
    double currentDvCalculator(double dv) {
        return gain * (elementDependant.currentCalculator());
    }

    CDCurrentSource(String input) {
        super(input);
        type = 'F';
    }
}

class VDCurrentSource extends VoltageDependant {
    @Override
    double currentCalculator() {
        return gain * (startDependant.voltage - endDependant.voltage);
    }

    @Override
    double currentDvCalculator(double dv) {
        return gain * (startDependant.voltage - endDependant.voltage);
    }

    VDCurrentSource(String input) {
        super(input);
        type = 'G';
    }
}
