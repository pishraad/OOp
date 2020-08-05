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
        current = value + amplitude * Math.cos(2 * Math.PI * frequency * t + phase);
        return current;
    }
}
class CDCurrentSource extends  CurrentDependant {
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
        return 0 ;
    }

    CDCurrentSource(String input) {
        super(input);
        type = 'F';
    }
}

class VDCurrentSource extends VoltageDependant {
    @Override
    double currentCalculator() {
        current = gain * (startDependant.voltage - endDependant.voltage);
        return current;
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
