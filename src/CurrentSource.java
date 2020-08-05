public class CurrentSource extends Source {
    CurrentSource(String input) {
        super(input);
        type = 'I';
    }

    @Override
    double currentCalculator() {
        return 0;
    }

    @Override
    double currentDvCalculator(double dv) {
        return 0;
    }

    double currentCalculator(double t) {
        current = value + amplitude * Math.cos(2 * Math.PI * frequency * t + phase);
        return current;
    }
}

class CDCurrentSource extends CurrentDependant {
    CDCurrentSource(String input) {
        super(input);
        type = 'F';
    }

    @Override
    double currentCalculator() {
        switch (elementDependant.type) {
            case 'I':
                elementDependant.current = ((CurrentSource) elementDependant).currentCalculator(t);
                break;
            case 'V':
            case 'H':
            case 'E':
                elementDependant.current = VoltageSource.VSCurrentCalculator(elementDependant, t);
                break;
            default:
                elementDependant.current = elementDependant.currentCalculator();
                break;
        }
        current = gain * (elementDependant.current);
        return current;
    }

    @Override
    double currentDvCalculator(double dv) {
        return 0;
    }
}

class VDCurrentSource extends VoltageDependant {
    VDCurrentSource(String input) {
        super(input);
        type = 'G';
    }

    @Override
    double currentCalculator() {
        current = gain * (startDependant.voltage - endDependant.voltage);
        return current;
    }

    @Override
    double currentDvCalculator(double dv) {
        return gain * (startDependant.voltage - endDependant.voltage);
    }
}
